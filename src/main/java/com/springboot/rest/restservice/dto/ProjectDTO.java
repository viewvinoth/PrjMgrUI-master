package com.springboot.rest.restservice.dto;

public class ProjectDTO {
	private int project_id;
	private String project;
	private String startDate;
	private String endDate;
	private int priority;
	private int user_id;
	private int noOfTasks;
	private int noOfCompletedTasks;
	
	public ProjectDTO(int project_id, String project, String startDate, String endDate, int priority, int user_id,
			int noOfTasks, int noOfCompletedTasks) {
		super();
		this.project_id = project_id;
		this.project = project;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.user_id = user_id;
		this.noOfTasks = noOfTasks;
		this.noOfCompletedTasks = noOfCompletedTasks;
	}
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNoOfTasks() {
		return noOfTasks;
	}
	public void setNoOfTasks(int noOfTasks) {
		this.noOfTasks = noOfTasks;
	}
	public int getNoOfCompletedTasks() {
		return noOfCompletedTasks;
	}
	public void setNoOfCompletedTasks(int noOfCompletedTasks) {
		this.noOfCompletedTasks = noOfCompletedTasks;
	}
}
