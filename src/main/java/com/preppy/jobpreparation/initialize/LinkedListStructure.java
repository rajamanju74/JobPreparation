package com.preppy.jobpreparation.initialize;

import com.preppy.jobpreparation.pojos.LinkedListNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class LinkedListStructure {
    @Setter
    @Getter
    private static LinkedListNode head = null;
    @Setter
    @Getter
    private static LinkedList<Integer> list = null;

/*    public static LinkedListNode getHead(){
        return head;
    }
    public static void setHead(LinkedListNode node){
        head = node;
    }*/

}
