package com.lecture.thrift;


import com.lecture.automatic.thrfit.DataException;
import com.lecture.automatic.thrfit.Person;
import com.lecture.automatic.thrfit.PersonService;
import org.apache.thrift.TException;


public class Thrift_Person_ServiceImpl implements PersonService.Iface
{

	@Override
	public Person getPersonByUsername(String username) throws DataException, TException {
		
		System.out.println("come on:getPersonByUsername");
		
		Person person = new Person();
		person.setUsername(username);
		person.setMarried(false);
		person.setAge(20);
		
		return person;
	}

	@Override
	public void savePerson(Person person) throws DataException, TException {
		System.out.println("come on:savePerson");
		
		System.out.println(person.getUsername());
		System.out.println(person.getAge());
		System.out.println(person.isMarried());
		
	}

}
