package com.tricon.LoginService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.LoginService.entity.Login;
import com.tricon.LoginService.repository.LoginRepository;

@RestController
@RequestMapping("/value")

public class LoginController {

	LoginController() {
		System.out.println("LoginController created");
	}

	@Autowired
	private LoginRepository loginRepository;

	@PostMapping
	@CacheEvict(value = "allposts",allEntries = true)
	public Login save(@RequestBody Login login) {
		System.out.println("saving");
		 loginRepository.save(login);
		 return login;
	}

	@GetMapping
	@Cacheable(value = "allposts")
	public List<Login> getAllData() {
		System.out.println("get all founds");
		return loginRepository.findAll();
		//return null;
	}


	@PutMapping
	@CacheEvict(value = "allposts",allEntries = true)
	public Login update(@RequestBody Login login) {
		return loginRepository.save(login);
	}
}
