package com.hss;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonDao extends CrudRepository<Person, Integer> {

	//findBy or findAllBy methods

	@Query(value = "select p from persons p inner join cars c on p.id=c.person_id", 
			nativeQuery = true)
	List<Person> findAllWithAtleast2CarsNative(int size);
	
	@Query("select p from Person p where p.cars.size >= :p1")
	List<Person> findAllWithAtleast2Cars(@Param("p1") int size);
	
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
