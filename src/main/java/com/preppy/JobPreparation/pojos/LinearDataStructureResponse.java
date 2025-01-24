package com.preppy.JobPreparation.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinearDataStructureResponse {
    String response;
    List<Integer> list;
    String operation;
    HttpStatusCode statusCode;
}
