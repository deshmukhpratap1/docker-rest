package com.levo.dockerexample.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.levo.dockerexample.entity.Issue;
import com.levo.dockerexample.repository.IssueRepository;

import net.snowflake.client.jdbc.internal.apache.http.HttpStatus;
import net.snowflake.client.jdbc.internal.google.api.client.http.HttpHeaders;

@CrossOrigin
@RestController
@RequestMapping("docker-java-app")
public class HelloController {
	
	@Autowired
	IssueRepository issueRepo;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "docker-java-app is up and running: " + new Date();
	}

	@RequestMapping(value = "/issues", method = RequestMethod.GET)
	public List<Issue> getAllIssues() {
		System.out.println("getting list of issues");
		List<Issue> issues = issueRepo.findAllIssues();
		return issues;
		//return new ResponseEntity<List<Issue>> (issues,new HttpHeaders(), HttpStatus.SC_OK);  
	}
}
