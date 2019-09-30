package netty_practice.thrift;

import generated.DataException;
import generated.Person;
import generated.PersonService;
import org.apache.thrift.TException;

import java.io.*;

public class Thrift_Person_ServiceImpl implements PersonService.Iface
{

	@Override
	public Person getPersonByUsername(String username) throws DataException, TException {
		
		System.out.println("come on:getPersonByUsername");
		
		Person person = new Person();
		person.setUsername(username);
		person.setMarried(false);
		person.setAge(20);

		File file = new File("D://concurrenttest.txt");

		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
			writer.write("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

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
