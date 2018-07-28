package io.javabrains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		
		
		User user = new User(name, email);
		userRepository.save(user);
		
		return "Saved";
	}
	
	@RequestMapping("/all")
	public @ResponseBody List<User> findAll() {
		
		List<User> list = new ArrayList<User>();
		userRepository.findAll().forEach(list::add);
		
		return list;
		
	} 
	
	
	
	

}
