package com.verizon.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.graphql.entity.Tutorial;
@Repository
public interface TutorialRepo extends JpaRepository<Tutorial, Long> {

}
