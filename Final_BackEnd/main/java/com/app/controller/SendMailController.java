package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailDTO;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/ekisan/email")
@CrossOrigin(origins = "http://localhost:3000")
public class SendMailController {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private IUserService userService;

	@PostMapping("/send")
	public String processForm(@RequestBody EmailDTO emDto) {
		User customer = userService.findUserById(emDto.getCustId());

		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(customer.getEmail());
		mesg.setSubject("Shopping With E-Kisan");
		mesg.setText("You have successfully completed shopping with E-Kisan. " + "\nYour Total Bill Amount is : "
				+ emDto.getBillAmount() + " rupees");
		sender.send(mesg);
		return "Email Successfully Sent to " + customer.getEmail();
	}
	
	@PostMapping("/forgot/{email}")
	public String forgotPassowrd(@PathVariable String email) {
		User customer = userService.findUsrByMail(email);
		SimpleMailMessage mesg = new SimpleMailMessage();
		mesg.setTo(customer.getEmail());
		mesg.setSubject("Shopping With E-Kisan(Forgot Password)");
		mesg.setText("Name :  " + customer.getName() +"\nPassword : "+ customer.getPassword());
		sender.send(mesg);
		return "Password Successfully Sent to " + customer.getEmail();
	}


}
