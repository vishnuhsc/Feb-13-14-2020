package com.hss;

import java.lang.reflect.Method;
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
	
	@GetMapping("/name/{name}/age/{age}")
	public List<Person> getByNameOrAge(@PathVariable String name, @PathVariable int age ) {
		return personDao.findAllByNameOrAge(name, age);
	}
	
	@GetMapping("/name/{name}")
	public Person getByName(@PathVariable String name) {
		return personDao.findByName(name);
	}
	
	@GetMapping("/meta")
	public String getInfo() {
		String meta = "********************** <br/>";
		meta += " Class name: " + personDao.getClass().getName() + "<br/><br/>";
		meta += "<---INTERFACES --> <br/>";
		for(Class interfaceCls : personDao.getClass().getInterfaces()) {
			meta += interfaceCls.getName() + "<br/>";
		}
		meta += "<br/><---METHODS --> <br/>";
		for(Method method : personDao.getClass().getMethods()) {
			meta += method.getName() + "<br/>";
		}
		return meta;
	}
	
	
	//@PostMapping("/create/{name}/{age} WRONG Don't use verbs in url
	
	
	@PatchMapping("/id/{id}/age/{age}")
	public String updateAge(@PathVariable int id, @PathVariable("age") int newAge) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			person.setAge(newAge);
			personDao.save(person);
			return "Age updated";
		}
		else {
			return "Person with " + id + " is not available";
		}
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			personDao.delete(person);
		}
		else {
			return "Person with id " + id + " not found";
		}
		return "Person deleted";
	}
	
	@PostMapping("/{name}/{age}")
	public String createPerson(@PathVariable String name, @PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personDao.save(person);
		return "Person with id " + person.getId() + " created";
	}
	
	@GetMapping
	public List<Person> getAllPersons() {
		return (List<Person>)personDao.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
