package com.lecture.grpc;

import com.lecture.automatic.grpc.MyRequest;
import com.lecture.automatic.grpc.MyResponse;
import com.lecture.automatic.grpc.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentService extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("来自客户端grpc消息:"+request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("大哥").build());

        responseObserver.onCompleted();
    }
}
