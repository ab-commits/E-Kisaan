package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/ekisan/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> getUserByEmailAndPassword(@RequestBody @Valid UserDTO udto) {
		return new ResponseEntity<>(userService.getUserDetails(udto.getEmail(), udto.getPassword()), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addUserDetails(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.addUserDetails(user), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateUserDetails(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);

	}

	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id) {
		return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
	}

	@GetMapping("/getAllUsers/")
	public ResponseEntity<?> getUser() {
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}

}
