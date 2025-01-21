package com.preppy.JobPreparation.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenceResponse {
    private List<Integer> sequence;
    private int number;
    private String sequenceType;
    private String status;
}
