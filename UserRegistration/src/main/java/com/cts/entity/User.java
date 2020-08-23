package com.cts.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author 844226 - mahesh 
 * @implNote user Entity
 *
 */

@ApiModel(description = "This is the user entity")
@Entity
public class User {
	
	@ApiModelProperty(value = "A unique key for each USER")
	@Id
	@GeneratedValue
	private int id;
	
	@ApiModelProperty(value = "FirstName of the user")
	@NotNull(message = "Name cannot be null")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "firstname shold be in alphabetsonly")
	@Size(min = 2, message = "firstname must have atleast 2 characters")
	private String firstName;
	
	@ApiModelProperty(value = "lastName of the user")
	@NotNull(message = "lastName cannot be null")
	@Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "lastname can only have alphabets with minimum length 2")
	@Size(min = 2, message = "firstname must have atleast 2 characters")
	private String lastName;
	
	@ApiModelProperty(value = "password of user")
	@NotNull(message = "password cannot be null")
	@Pattern(regexp = "[a-zA-Z0-9]{4}[A-Za-z0-9\\s]*", message = "password  minimum length is 4")
	@Size(min = 4, message = "firstname must have atleast 4 characters")
	private String password;
	
	@ApiModelProperty(value = "conformPassword of user")
	@NotNull(message = "conformPassword cannot be null")
	@Pattern(regexp = "[a-zA-Z0-9]{4}[A-Za-z0-9\\s]*", message = "conformPassword   minimum length is 4")
	@Size(min = 4, message = "conformPassword must have atleast 4 characters")
	private String conformPassword;
	
	@ApiModelProperty(value = "email of user")
	@Email(message="Pls provide a valid email address ")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String email;	
	
	@ApiModelProperty(value = "contactNumber of user")
	@Pattern(regexp="(^[1-9]{1}[0-9]{9}$)",message = "mobile number should not start with '0'.and it should contains 10 digits")
	private String contactNumber;
	
	@ApiModelProperty(value = "pan number of user and it should be unique")
	@Column(unique = true)	
	@Pattern(regexp="(^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$)",message = "pan number format is not correct")
	private String pan;
	
	@ApiModelProperty(value = "date of birth of user")
	@JsonFormat(pattern="MM-dd-yyyy")
//	@Pattern(regexp = "(^(1[0-2]|0[1-9]).(3[01]|[12][0-9]|0[1-9]).[0-9]{4}$)",message = "date format should be in format of MM-dd-yyy.")
	@Past(message ="DOB should be in past")
    private LocalDate birthday;
	
	@Transient 
	private int age;
	
	

	public User() {
		super();
	}

	public User(int id,
			@NotNull(message = "Name cannot be null") @Pattern(regexp = "^[a-zA-Z]+$", message = "firstname shold be in alphabetsonly") @Size(min = 2, message = "firstname must have atleast 2 characters") String firstName,
			@NotNull(message = "lastName cannot be null") @Pattern(regexp = "[a-zA-Z]{2}[A-Za-z\\s]*", message = "lastname can only have alphabets with minimum length 2") @Size(min = 2, message = "firstname must have atleast 2 characters") String lastName,
			@NotNull(message = "password cannot be null") @Pattern(regexp = "[a-zA-Z0-9]{4}[A-Za-z0-9\\s]*", message = "password  minimum length is 4") @Size(min = 4, message = "firstname must have atleast 4 characters") String password,
			@NotNull(message = "conformPassword cannot be null") @Pattern(regexp = "[a-zA-Z0-9]{4}[A-Za-z0-9\\s]*", message = "conformPassword   minimum length is 4") @Size(min = 4, message = "conformPassword must have atleast 4 characters") String conformPassword,
			@Email(message = "Pls provide a valid email address ") @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address") String email,
			@Pattern(regexp = "(^[1-9]{1}[0-9]{9}$)", message = "mobile number should not start with '0'.and it should contains 10 digits") String contactNumber,
			@Pattern(regexp = "(^[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}$)", message = "pan number format is not correct") String pan,
			@Past(message = "DOB should be in past") LocalDate birthday) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.conformPassword = conformPassword;
		this.email = email;
		this.contactNumber = contactNumber;
		this.pan = pan;
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@JsonIgnore
	private String role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getConformPassword() {
		return conformPassword;
	}

	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}

	
	
	
	
	
	
}
