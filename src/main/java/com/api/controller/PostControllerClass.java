package com.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.postservice.PostService;

@RestController
@RequestMapping("/get")
public class PostControllerClass {

	
	@Autowired
	private PostService postService;
	
	@GetMapping ("/getall")
	public List<Map<String,Object>> getAll(){
		System.out.println("Controller class.........");
		return postService.getPosts();
	}
	
	@GetMapping ("/getData/{id}")
	public Map<String,Object> getById(@PathVariable int id){
		return postService.getPost(id);
	}
	
	
	@PostMapping ("/post")
	public Map<String,Object> postData(@RequestBody Map<String,Object> payload){
		System.out.println("....1");
		return postService.insertPost(payload);
	}
}

           
