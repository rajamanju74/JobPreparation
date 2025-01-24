package com.preppy.JobPreparation.initialize;

import java.util.ArrayList;
import java.util.List;

public class QueueStructure {
    private QueueStructure(){
        this.queue = new ArrayList<>();
    }
    public static QueueStructure queueStructure;
    public List<Integer> queue;

    public static QueueStructure getQueue(){
        if(queueStructure == null){
            queueStructure = new QueueStructure();
        }
        return queueStructure;
    }
}
