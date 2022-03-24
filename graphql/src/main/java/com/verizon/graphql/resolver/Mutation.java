package com.verizon.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.verizon.graphql.entity.Author;
import com.verizon.graphql.entity.Tutorial;
import com.verizon.graphql.repo.AuthorRepo;
import com.verizon.graphql.repo.TutorialRepo;

@Component
public class Mutation implements GraphQLMutationResolver{
	
	private AuthorRepo authorRepo;
	private TutorialRepo tutorialRepo;
	
	@Autowired
	public Mutation(AuthorRepo authorRepo,TutorialRepo tutorialRepo) {
		this.authorRepo=authorRepo;
		this.tutorialRepo=tutorialRepo;
	}
	
	public Author createAuthor(String name,Integer age)
	{
		Author author=new Author();
		author.setAge(age);
		author.setName(name);
		authorRepo.save(author);
		return author;
	}
	
	public Tutorial createTutorial(String title,String description,Long authorId)
	{
		Tutorial tutorial=new Tutorial();
		tutorial.setAuthor(new Author(authorId));
		tutorial.setTitle(title);
		tutorial.setDescription(description);
		tutorialRepo.save(tutorial);
		return tutorial;
	}
	
	public boolean deleteTutorial(Long id)
	{
		tutorialRepo.deleteById(id);
		return true;
	}
	
	public Tutorial updateTutorial(Long id,String title,String description)throws NotFoundException
	{
		Optional<Tutorial> optTutorial=tutorialRepo.findById(id);
		if(optTutorial.isPresent())
		{
			Tutorial tutorial =optTutorial.get();
			if(title!=null)
			{
				tutorial.setTitle(title);
				
			}
			if(description!=null)
			{
				tutorial.setDescription(description);
			}
			tutorialRepo.save(tutorial);
			return tutorial;
		}
		return null;
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
