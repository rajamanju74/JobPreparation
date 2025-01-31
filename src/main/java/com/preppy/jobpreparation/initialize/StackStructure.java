package com.preppy.jobpreparation.initialize;

import java.util.ArrayList;
import java.util.List;

public class StackStructure {
    private StackStructure(){
        this.stack = new ArrayList<>();
    }
    public static StackStructure stackStructure;
    public List<Integer> stack;

    public static StackStructure getStack(){
        if(stackStructure == null){
            stackStructure = new StackStructure();
        }
        return stackStructure;
    }
}
