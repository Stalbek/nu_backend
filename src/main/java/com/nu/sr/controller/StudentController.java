package com.nu.sr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nu.sr.domain.StudentCard;
import com.nu.sr.service.StudentCardService;


@RepositoryRestController
@RequestMapping(value = "sc")
public class StudentController {

	@Autowired
	StudentCardService stdCardService;
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaTypes.HAL_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> saveContract(@RequestBody StudentCard studentCard) {
		if (studentCard != null) {
			try {
	        	StudentCard createdSc = stdCardService.saveNewStudentCard(studentCard);
	        	return ResponseEntity
	        			.status(HttpStatus.CREATED)
	        			.body(createdSc);
	        } catch(Exception ex) {
	        	ex.printStackTrace();
	        	return ResponseEntity
	                    .status(HttpStatus.BAD_REQUEST)
	                    .body(ex.getMessage());
	        }
        } else {
            return ResponseEntity
            		.status(HttpStatus.NO_CONTENT)
            		.header("reason", "Student Card is null")
            		.body(studentCard);
        }
    }
	
}
