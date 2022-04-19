package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import models.UserModel;
import services.UserManagement;

@Controller
public class UserController {
	@Autowired
	UserManagement userManagementService;
	
	@GetMapping("/getUsers")
	public String getUsers(Model model) {
		model.addAttribute("users", userManagementService.getUsers());
		return "show-users";
	}
	
	@GetMapping("/addUser")
	public String addUserView(@ModelAttribute("user") UserModel user) {
		return "add-user";
	}
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") UserModel user) {
		userManagementService.add(user);
		return "redirect:getUsers";
	}
	
	@GetMapping("/editUser")
	public String editUserView(@ModelAttribute("user") UserModel user) {
		return "edit-user";
	}
	@PostMapping("/editUser")
	public String editUser(@ModelAttribute("user") UserModel user) {
		userManagementService.edit(user);
		return "redirect:getUsers";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUserView(@ModelAttribute("user") UserModel user) {
		return "delete-user";
	}
	@PostMapping("/deleteUser")
	public String deleteUser(@ModelAttribute("user") UserModel user) {
		userManagementService.delete(user.getId());
		return "redirect:getUsers";
	}
	
}
