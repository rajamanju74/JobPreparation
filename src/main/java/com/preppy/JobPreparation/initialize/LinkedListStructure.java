package com.preppy.JobPreparation.initialize;

import com.preppy.JobPreparation.pojos.LinkedListNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class LinkedListStructure {
    @Setter
    @Getter
    private static LinkedListNode head = null;

/*    public static LinkedListNode getHead(){
        return head;
    }
    public static void setHead(LinkedListNode node){
        head = node;
    }*/

}
