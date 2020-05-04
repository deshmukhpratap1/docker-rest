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

	@Transactional(readOnly = true)
	public List<Issue> findAllIssues() {
		return jdbcTemplate.query("select * from ISSUE", new IssueMapper());
	}

	public void createIssue(Issue issue) {
		String sqlQuery = "insert into ISSUE(ISSUE_NAME,ISSUE_DETAILS) " + "values (?, ?)";
		jdbcTemplate.update(sqlQuery, issue.getIssue_name(), issue.getIssue_message());
	}

	public Issue getIssueById(Long id) {
		String sqlQuery = "select * from ISSUE where ISSUE_ID = ?";
		return jdbcTemplate.queryForObject(sqlQuery, new IssueMapper(), id);
	}

	public void updateIssueById(Long id, Issue issue) {
		String sqlQuery = "update ISSUE set " + "ISSUE_NAME = ?, ISSUE_DETAILS = ?"
				+ "where ISSUE_ID = ?";
		jdbcTemplate.update(sqlQuery, issue.getIssue_name(), issue.getIssue_message(),
				issue.getId());
	}

	public boolean deleteConsultantById(Long id) {
		String sqlQuery = "delete from ISSUE where ISSUE_ID = ?";
		return jdbcTemplate.update(sqlQuery, id) > 0;
	}

}
