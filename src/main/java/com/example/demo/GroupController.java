package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupController {

	@ModelAttribute
	public GroupFrom setUpForm() {
		return new GroupFrom();
	}

	@RequestMapping("/group_input")
	public String index() {
		return "group_index.html";
	}

	@RequestMapping("/group_output")
	public String result(@Validated GroupFrom groupFrom, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "group_index.html";
		}

		String number = groupFrom.getNumber();

		//String name = "コントローラー太郎";
		GroupService groupService = new GroupServiceImpl();
		String name = groupService.findByNo(number);
		model.addAttribute("number", number);
		model.addAttribute("name", name);
		return "group_output.html";
	}

}