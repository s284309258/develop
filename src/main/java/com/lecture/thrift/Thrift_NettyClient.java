package com.lecture.thrift;

import com.lecture.automatic.thrfit.Person;
import com.lecture.automatic.thrfit.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


public class Thrift_NettyClient 
{
	public static void main(String[] args) {
		TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
		TProtocol protocol = new TCompactProtocol(transport);
		PersonService.Client client = new PersonService.Client(protocol);
		
		try
		{
			transport.open();
			Person person = client.getPersonByUsername("张三");
			System.out.println(person.getUsername());
			System.out.println(person.getAge());
			System.out.println(person.isMarried());
			
			Person person2 = new Person();
			person2.setAge(66);
			person2.setUsername("老板");
			person2.setMarried(true);
			
			client.savePerson(person2);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			transport.close();	
		}
	}
}
