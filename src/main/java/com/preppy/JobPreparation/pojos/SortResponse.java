package com.preppy.JobPreparation.pojos;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
public class SortResponse {
    String method;
    List<Integer> inputArray;
    String message;
    HttpStatusCode status;
    List<Integer> sortedArray;
}
