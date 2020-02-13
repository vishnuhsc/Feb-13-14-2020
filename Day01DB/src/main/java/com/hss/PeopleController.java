package com.hss;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PeopleController {

	@Autowired
	private PersonDao personDao;
	
	//@PostMapping("/create/{name}/{age} WRONG Don't use verbs in url
	
	
	@PatchMapping("/id/{id}/age/{age}")
	public String updateAge(int id, int newAge) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			
		}
		else {
			return "Person with " + id + " is not available";
		}
		//Update age of person
		//If person with given id is not available report 
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(int id) {
		//Delete person
		//If person with given id is not available report
		return null;
	}
	
	
	@PostMapping("/{name}/{age}")
	public String createPerson(@PathVariable String name, @PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personDao.save(person);
		return "Person with id " + person.getId() + " created";
	}
	
	@GetMapping("/")
	public List<Person> getAllPersons() {
		return (List<Person>)personDao.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
