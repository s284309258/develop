package netty_practice.thrift;

import generated.Person;
import generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class Thrift_NettyClient implements Runnable
{
	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			Thrift_NettyClient client = new Thrift_NettyClient();
			client.run();

		}
//		TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
//		TProtocol protocol = new TCompactProtocol(transport);
//		PersonService.Client client = new PersonService.Client(protocol);
//
//		try
//		{
//			transport.open();
//			for(int i=0;i<1000;i++){
//				Person person = client.getPersonByUsername("张三");
//				System.out.println(person.getUsername());
//				System.out.println(person.getAge());
//				System.out.println(person.isMarried());
//
//				Person person2 = new Person();
//				person2.setAge(66);
//				person2.setUsername("老板");
//				person2.setMarried(true);
//
//				client.savePerson(person2);
//				System.out.println("i======"+i);
//			}
//
//
//
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			transport.close();
//		}
	}

	@Override
	public void run() {
		TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
		TProtocol protocol = new TCompactProtocol(transport);
		PersonService.Client client = new PersonService.Client(protocol);

		try
		{
			transport.open();
			for(int i=0;i<100;i++){
				Person person = client.getPersonByUsername("张三");
				System.out.println(person.getUsername());
				System.out.println(person.getAge());
				System.out.println(person.isMarried());

				Person person2 = new Person();
				person2.setAge(66);
				person2.setUsername("老板");
				person2.setMarried(true);

				client.savePerson(person2);
				System.out.println("i======"+i);
			}



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
