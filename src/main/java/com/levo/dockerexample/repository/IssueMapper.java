package com.levo.dockerexample.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.levo.dockerexample.entity.Issue;

public class IssueMapper implements org.springframework.jdbc.core.RowMapper<Issue> {

	@Override
	public Issue mapRow(ResultSet rs, int rowNum) throws SQLException {
		Issue issue= new Issue();
		issue.setId(rs.getInt("ISSUE_ID"));
		issue.setIssue_name(rs.getString("ISSUE_NAME"));
		issue.setIssue_message(rs.getString("ISSUE_DETAILS"));
		return issue;
	}
	

}
