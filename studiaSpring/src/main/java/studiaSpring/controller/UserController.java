package studiaSpring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studiaSpring.entity.User;
import studiaSpring.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		List<User> theUsers = userService.findAll();
		
		theModel.addAttribute("users", theUsers);
		
		return "users/list-users";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		User theUser = new User();

		theModel.addAttribute("user", theUser);
		
		return "users/user-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") Long theId,
									Model theModel) {
		
		User theUser = userService.findById(theId);
		
		theModel.addAttribute("user", theUser);
		
		return "users/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {
		
		userService.save(theUser);
		
		return "redirect:/users/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId") Long theId) {
		
		userService.deleteById(theId);
		
		return "redirect:/users/list";
	}

}
