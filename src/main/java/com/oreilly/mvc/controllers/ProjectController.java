package com.oreilly.mvc.controllers;

import com.oreilly.mvc.data.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @RequestMapping(value = "/{projectId}")
    public String findProject(Model model, @PathVariable Long projectId) {
        model.addAttribute("project", this.projectService.find(projectId));

        return "project";
    }

    @RequestMapping(value="/find")
    public String find(Model model) {
        model.addAttribute("projects", this.projectService.findAll());

        return "projects";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addProject(HttpSession session) {
        session.setAttribute("token", "12345");
        return "project_add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String saveProject(HttpServletRequest request, HttpSession session) {
        System.out.println(request.getParameter("name"));
        System.out.println(session.getAttribute("token"));
        System.out.println("invoking save porject");
        return "project_add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, params = {"type=multi"})
    public String multiYearProject() {
        System.out.println("invoking multiyear  porject");
        return "project_add";
    }


}
