package Group.Employee.Management.System.Employee_API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group.Employee.Management.System.Employee_API.model.User;
import Group.Employee.Management.System.Employee_API.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository; 
	
	// CREATE
	public User createUser(User u) {
		return userRepository.save(u);
	}
	
	// READ
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	// DELETE
	public void delUser(Long id) {
		userRepository.deleteById(id);
	}
	
	// UPDATE
	public User updateUser(Long id, User uDetails) {
		User uUpdate = userRepository.findById(id).get();
		uUpdate.setFullname(uDetails.getFullname());
		uUpdate.setPhone_number(uDetails.getPhone_number());
		uUpdate.setEmail(uDetails.getEmail());
		uUpdate.setUsername(uDetails.getUsername());
		uUpdate.setPassword(uDetails.getPassword());
		uUpdate.setCreated_at(uDetails.getCreated_at());
		uUpdate.setUpdated_at(uDetails.getUpdated_at());
		
		return userRepository.save(uUpdate);
	}
	
}
