package com.preppy.jobpreparation.pojos;

import lombok.Data;

import java.util.List;

@Data
public class SortRequest {
    //List<Integer> sortedArray;
    String method;
    List<Integer> givenArray;
}
