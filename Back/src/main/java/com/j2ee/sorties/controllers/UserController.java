package com.j2ee.sorties.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.sorties.entities.User;
import com.j2ee.sorties.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.PUT)
	public User createOrUpdate(@RequestBody @Valid User user) {
		return userService.createOrUpdate(user);
	}
	
	@RequestMapping(path = "/{username}", method = RequestMethod.GET)
	public User get(@PathVariable(name = "username") String username) {
		return userService.getUserById(username);
	}

	@Operation(summary = "Récupération de tous les utilisateurs")
	@RequestMapping(path = "/_all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable(name = "username") String username) {
		userService.deleteUser(username);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Page<User> getUsers(Pageable pageable) {
		return userService.getUsersWithPaging(pageable);
	}
}
