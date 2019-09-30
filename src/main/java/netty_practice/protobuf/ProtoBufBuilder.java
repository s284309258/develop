package netty_practice.protobuf;

import protos.*;

public class ProtoBufBuilder {
	public static void main(String[] args) throws Exception {
		datainfo.Student student = datainfo.Student.newBuilder().setAddress("深圳坂田").setAge(20).setName("哈哈哈哈哈哈").build();
		byte[] bytearray2 = student.toByteArray();

		datainfo.Student student2 = datainfo.Student.parseFrom(bytearray2);
		System.out.println(student2.getAddress());
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
	}
}
