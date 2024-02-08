package com.example.grpc.server.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
        String idClient;
        String fullName;
        String infoReport;
}
