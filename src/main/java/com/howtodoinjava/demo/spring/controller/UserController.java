package com.howtodoinjava.demo.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.howtodoinjava.demo.spring.model.User;
import com.howtodoinjava.demo.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
        //PAGINA DE USER
	@GetMapping("/")
	public String userForm(Locale locale, Model model) {
		model.addAttribute("users", userService.list());
                //NOMBRE DE LA VISTA QUE RETORNA
		return "editUsers";
	}
	
	@ModelAttribute("user")
    public User formBackingObject() {
        return new User();
    }

	@PostMapping("/addUser")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("users", userService.list());
                        //REDIRECCIONA A LA VISTA DE EDITUSER
			return "editUsers";
		}

		userService.save(user);
                //REDIRECCIONA AL PRINCIPAL
		return "redirect:/";
	}
}
