package com.nu.sr.domain;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.DatatypeConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student {

	private Integer id;
	private String firstname;
	private String lastname;
	private String middlename;
	private Date birthday;
	private String info;
	private Blob photo;

	public Student() { }

	public Student(Integer id) {
		this.id = id;
	}
	
	public Student(Integer id, String firstname, String lastname, String middlename, Date birthday, String info,
			Blob photo) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.birthday = birthday;
		this.info = info;
		this.photo = photo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "firstname", nullable = false, length = 45)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name = "lastname", nullable = false, length = 45)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Column(name = "middlename", length = 45)
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(name = "info", length = 45)
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	@JsonIgnore
	@Column(name = "photo")
	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	
	@JsonIgnore
	@Transient
	public String getPhotoString() throws SQLException {
		String str = "";
		if(photo != null) {
			int blobLength = (int) photo.length();  
			byte[] blobAsBytes = photo.getBytes(1, blobLength);
			str = DatatypeConverter.printBase64Binary(blobAsBytes);
			photo.free();
		}
		return str;
	}
	
}