package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class User extends BaseEntity {
	@Column(length = 30)
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="dob is required")
	private LocalDate dob;
	@Column(length = 30,unique=true)
	@NotBlank(message = "email is mandatory")
	@Email
	private String email;
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "invalid password")
	@Column(length = 25)
	@NotBlank(message = "password is mandatory")
	private String password;
	@NotBlank(message = "Address is mandatory")
	@Column(length = 50)
	private String address;
	@Column(length = 10,unique=true)
	@NotBlank(message = "Phone No is mandatory")
	@JsonProperty("phone")
	private String phoneNo;
	@Column(length=8)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
}
