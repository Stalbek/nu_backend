package com.nu.sr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nu.sr.domain.Student;
import com.nu.sr.domain.projection.StudentProjection;

@RepositoryRestResource(collectionResourceRel = "stdrepo", path = "stdrepo",
	excerptProjection = StudentProjection.class)
public interface StudentDao extends JpaRepository<Student, Integer> {

}
