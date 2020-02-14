package com.hss;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Lab02Controller {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private CarDao carDao;
	
	
	@GetMapping("/lab02/personswithcars/{size}")
	public List<Person> getPersonsWith2Cars(@PathVariable int size) {
		return personDao.findAllWithAtleast2Cars(size);
	}
	
	
	@PostMapping("/lab02/person/{id}")
	public String addCar(@RequestBody Car car, @PathVariable int id) {
		Optional<Person> optPerson = personDao.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			car.setOwner(person);
			carDao.save(car);
		}
		else {
			return "Person not found";
		}
		return "Car with id " + car.getId() + " added to person";
	}
	
	
}










