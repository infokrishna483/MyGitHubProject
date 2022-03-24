package com.verizon.graphql.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.verizon.graphql.entity.Author;
import com.verizon.graphql.entity.Tutorial;
import com.verizon.graphql.repo.AuthorRepo;
import com.verizon.graphql.repo.TutorialRepo;



@Component
public class Query implements GraphQLQueryResolver{
	
	private AuthorRepo authorRepo;
	private TutorialRepo tutorialRepo;
	
	@Autowired
	public Query(AuthorRepo authorRepo,TutorialRepo tutorialRepo) {
		this.authorRepo=authorRepo;
		this.tutorialRepo=tutorialRepo;
	}
	
	
	public Iterable<Author> findAllAuthors()
	{
		return authorRepo.findAll();
	}
	
	public Iterable<Tutorial> findAllTutorials()
	{
		return tutorialRepo.findAll();
	}
	
	public long countAuthors()
	{
		return authorRepo.count();
	}
	
	public long countTutorials()
	{
		return tutorialRepo.count();
	}
	

}
