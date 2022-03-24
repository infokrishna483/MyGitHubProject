package com.verizon.graphql.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@javax.persistence.Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
	
	public Author(Long authorId) {
		this.id=authorId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int age;
	private String name;

}
