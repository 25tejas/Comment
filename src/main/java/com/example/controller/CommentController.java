package com.example.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Comment;
import com.example.model.User;
import com.example.repository.CommentRepository;
import com.example.repository.UserRepository;

@Controller
@RequestMapping("/comment")
public class CommentController 
{
	@Autowired
	UserRepository repo;
	
	@Autowired
	CommentRepository crepo;
	
	@RequestMapping("/add")
	public String m1(ModelMap map)
	{
		map.addAttribute("comment", new Comment());
		return "addcomment";
	}
	
	@PostMapping("/add")
	public String m2(@ModelAttribute("comment") Comment comment)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) 
		{
			UserDetails user= ((UserDetails)principal);
			User u=repo.findByUsername(user.getUsername());
		  
			comment.setUser(u);
			  
			crepo.save(comment);
			return "redirect:/";
		}
		else
		{
			return "addcomment";
		}
		
	}
	
	@RequestMapping("/")
	public String m3(ModelMap map)
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) 
		{
			UserDetails user= ((UserDetails)principal);
			User u=repo.findByUsername(user.getUsername());
		  
			map.addAttribute("psts",u.getComments());
		  	return "comments";
		}
		else
		{
			return "redirect:/";
		}
	}
}
