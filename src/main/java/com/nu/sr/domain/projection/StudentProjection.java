package com.nu.sr.domain.projection;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nu.sr.domain.Student;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Projection(name = "stdProj", types = { Student.class })
public interface StudentProjection {
	Integer getId();
	String getFirstname();
	String getLastname();
	String getMiddlename();
	Date getBirthday();
	String getInfo();
	String getPhotoString();
}
