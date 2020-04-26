package com.levo.dockerexample.entity;

public class Issue {

	private int id;
	private String issue_name;
	private String issue_message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIssue_name() {
		return issue_name;
	}
	public void setIssue_name(String issue_name) {
		this.issue_name = issue_name;
	}
	public String getIssue_message() {
		return issue_message;
	}
	public void setIssue_message(String issue_message) {
		this.issue_message = issue_message;
	}
	
}
