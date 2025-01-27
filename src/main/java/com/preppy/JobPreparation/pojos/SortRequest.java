package com.preppy.JobPreparation.pojos;

import lombok.Data;

import java.util.List;

@Data
public class SortRequest {
    //List<Integer> sortedArray;
    String method;
    List<Integer> givenArray;
}
