package com.lecture.thrift;

import com.lecture.automatic.thrfit.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;


public class Thrift_NettyServer {
	
	//cmd 命令 D:\thrift>thrift --gen java F:\jtim\netty_studio\src\main\java\netty_studio\data.thrift
	//默认生成文件路径为当前cmd命令目录即 D:\thrift,编译器thrift.exe(放在D:\thrift\thrift.exe),通常配置环境变量path=D:\thrift
	public static void main(String[] args) throws Exception {
		TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
		THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
		
		PersonService.Processor<Thrift_Person_ServiceImpl> processor = new PersonService.Processor<>(new Thrift_Person_ServiceImpl());
		
		arg.protocolFactory(new TCompactProtocol.Factory());
		arg.transportFactory(new TFramedTransport.Factory());
		arg.processorFactory(new TProcessorFactory(processor));
		
		TServer server = new THsHaServer(arg);
		
		server.serve();
	}
}
