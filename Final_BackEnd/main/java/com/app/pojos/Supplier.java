package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Supplier extends BaseEntity {
	@NotBlank
	@Column(length = 30)
	@JsonProperty("name")
	private String companyName;
	@NotBlank
	@Column(length = 30,unique=true)
	@JsonProperty("lnumber")
	private String licenceNumber;
	@NotBlank
	@Column(length = 30,unique=true)
	@JsonProperty("gstnumber")
	private String gstNumber;
	@NotBlank
	@Column(length = 30,unique=true)
	@Email
	private String email;
	@NotBlank
	@Column(length = 10)
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@JsonProperty("regdate")
	private LocalDate regDate;
	@NotBlank
	@Column(length = 50)
	private String address;
	@Column(length = 15,unique=true)
	@NotBlank(message = "Phone No is mandatory")
	@JsonProperty("phone")
	private String phoneNo;
}
