package com.preppy.jobpreparation.pojos;

public enum SequenceType {
    FIBONACCI("Fibonacci");
    private final String sequence;


    SequenceType(String sequence) {
        this.sequence = sequence;
    }
    public String getSequence(){ return sequence;}
}
