package com.levo.dockerexample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.levo.dockerexample.entity.Issue;

@Repository
public class IssueRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly= true)
	public List<Issue> findAllIssues(){
		return jdbcTemplate.query("select * from ISSUE", new IssueMapper());
		
	}
}
