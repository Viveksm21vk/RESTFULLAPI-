package com.johnson.app.rest.Controller;
import com.johnson.app.rest.models.User;
import com.johnson.app.rest.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
@RestController
public class ApiController {
	@Autowired
	private UserRepo userRepo;
	@GetMapping("/")
	public String getPage() {
		return "Welcome";
	}
	@GetMapping(value="/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	@PostMapping(value ="/save")
	public String saveUser(@RequestBody User user) {
		userRepo.save(user);
		return "Saved..";
	}
	
	@PutMapping(value="/update/{id}")
	public String updateUser(@PathVariable long id,@RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setOccupation(user.getOccupation());
		userRepo.save(updateUser);
		return "Updated...";	
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		User deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "Delete user with id: " + id;
	}
}

