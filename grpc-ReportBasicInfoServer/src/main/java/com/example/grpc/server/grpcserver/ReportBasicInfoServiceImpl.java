package com.example.grpc.server.grpcserver;

import com.example.grpc.server.model.Client;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class ReportBasicInfoServiceImpl extends getReportBasicInfoServiceGrpc.getReportBasicInfoServiceImplBase{
        @Override
        public void getReport(getReportBasicInfoRequest request,
                StreamObserver<getReportBasicInfoResponse> responseObserver) {

                Client client = new Client();
                client.setIdClient(request.getIdClient());
                if(client != null && client.getIdClient().equals("1")){
                        client.setFullName("Testname1 gRPC");
                        client.setInfoReport("TestInfoReport gRPC");
                }else{
                        client.setFullName("TestnameOther gRPC");
                        client.setInfoReport("TestInfoReport gRPC");
                }

                System.out.println("Servidor: "+client.toString());

                getReportBasicInfoResponse response = getReportBasicInfoResponse.newBuilder()
                        .setInfoReport(client.toString()).build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
        }
}
