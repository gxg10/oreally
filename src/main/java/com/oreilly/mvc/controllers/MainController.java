package com.oreilly.mvc.controllers;

import com.oreilly.mvc.data.entities.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

	@RequestMapping("/")
	public String greeting(Model model) {
		Project project = new Project();
		project.setName("First project");
		project.setSponsor("Nasa");
		project.setDescription("this is a sipmple project");

		model.addAttribute("currentProject", project);
		return "home";
	}
	
}
