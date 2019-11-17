package com.karki.ashish.hibernate_test_project.entities;

import java.io.Serializable;

//@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4095677242714825848L;

	public Employee() {

	};

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	};

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}