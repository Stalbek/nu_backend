package com.nu.sr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nu.sr.domain.StudentCard;

@RepositoryRestResource(collectionResourceRel = "stdcardrepo", path = "stdcardrepo")
public interface StudentCardDao extends JpaRepository<StudentCard, Integer> {
	
	@Query("from StudentCard s where "
			+ "s.student.id = ?1")
	List<StudentCard> getAllStudentCards(@Param("stdid") Integer stdid);
	
}
