package com.example.grpc.server.grpcserver;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientApplication {

        public static void main(String[] args){
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090)
                        .usePlaintext().build();

                getReportBasicInfoServiceGrpc.getReportBasicInfoServiceBlockingStub stub =
                        getReportBasicInfoServiceGrpc.newBlockingStub(channel);

                getReportBasicInfoResponse response = stub.getReport(
                        getReportBasicInfoRequest.newBuilder()
                                .setIdClient("1").build());
                System.out.println("Cliente:" + response);
                channel.shutdown();


        }
}
