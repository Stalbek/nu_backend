package com.nu.sr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nu.sr.dao.StudentCardDao;
import com.nu.sr.domain.StudentCard;
import com.nu.sr.service.StudentCardService;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentCardServiceImpl implements StudentCardService {

	@Autowired
	StudentCardDao studentCardDao;
	
	@Override
	public StudentCard saveNewStudentCard(StudentCard studentCard) throws Exception {
		try {
			StudentCard newStudentCard = studentCardDao.save(studentCard);
			return newStudentCard;
		} catch (Exception e) {
			throw e;
		}
	}

}
