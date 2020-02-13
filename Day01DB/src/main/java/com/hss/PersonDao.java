package com.hss;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person, Integer> {

	//findBy or findAllBy methods
	
	List<Person> findAllByNameOrAge(String name, int age);
	
	List<Person> findAllByName(String name);
	List<Person> findAllByAge(int age);
	List<Person> findAllByIdAndName(int id, String name);
	List<Person> findAllByIdAndAge(int id, int age);
	List<Person> findAllByIdAndNameAndAge(int id, String name, int age);
	
	
	Person findByName(String name);
	Person findByAge(int age);
	Person findByIdAndName(int id, String name);
	Person findByIdAndAge(int id, int age);
	Person findByIdAndNameAndAge(int id, String name, int age);
	
	
	
	
}
