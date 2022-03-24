package com.verizon.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.verizon.graphql.entity.Author;
import com.verizon.graphql.entity.Tutorial;
import com.verizon.graphql.repo.AuthorRepo;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

	 @Autowired
	  private AuthorRepo authorRepository;
	  public TutorialResolver(AuthorRepo authorRepository) {
	    this.authorRepository = authorRepository;
	  }
	  public Author getAuthor(Tutorial tutorial) {
	    return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	  }
	
	
}
