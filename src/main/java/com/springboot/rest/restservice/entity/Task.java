package com.springboot.rest.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int task_id;
	private int parent_id;
	private int project_id;
	private String task;
	private String start_date;
	private String end_date;
	private int priority;
	private String status;
	private int userId;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int task_id, int parent_id, int project_id, String task, String start_date, String end_date,
			int priority, String status, int userId) {
		super();
		this.task_id = task_id;
		this.parent_id = parent_id;
		this.project_id = project_id;
		this.task = task;
		this.start_date = start_date;
		this.end_date = end_date;
		this.priority = priority;
		this.status = status;
		this.userId = userId;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	}
