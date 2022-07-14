package Group.Employee.Management.System.Employee_API.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import Group.Employee.Management.System.Employee_API.responseHandle.ResponseHandle;
import Group.Employee.Management.System.Employee_API.model.User;
import Group.Employee.Management.System.Employee_API.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
    UserService userService;
	
	// CREAD
	@RequestMapping(value="/user/create", method=RequestMethod.POST)
	public User createNewUser(@RequestBody User userReqBody) {
	    return userService.createUser(userReqBody);
	}
	   
	// READ
//	@RequestMapping(value="/users", method=RequestMethod.GET)
//	public Object getAllUsers() {
//		return new ResponseHandle();
//		return userService.getUsers();
//	} // Constructor, getters and setters omitted
	
	
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public Object listAllUsers() {
		List<User> listUser = userService.getUsers();
		if (!listUser.isEmpty()) {
			return new ResponseEntity<>(new ResponseHandle(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	// UPDATE
	@RequestMapping(value="/user/{userId}", method=RequestMethod.PUT)
	public User updateUser(@PathVariable(value = "userId") Long id, @RequestBody User userReqBody) {
	    return userService.updateUser(id, userReqBody);
	}

	// DELETE
	@RequestMapping(value="/user/delete/{userId}", method=RequestMethod.DELETE)
	public void delEUser(@PathVariable(value = "userId") Long id) {
	    userService.delUser(id);
	}
}
