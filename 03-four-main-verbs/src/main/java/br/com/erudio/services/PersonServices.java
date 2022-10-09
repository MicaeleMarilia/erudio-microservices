package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
		
	}
	
	public Person findByID(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Micaele");
		person.setLastName("Marilia");
		person.setAddress("Vila Rica - PE");
		person.setGender("Feme");
		return person;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Lat Name " + i);
		person.setAddress("Some address in Brazil " + i);
		person.setGender("Feme");
		return person;

	}
}
