package com.preppy.JobPreparation.Service.SingleLinkedList;

import com.preppy.JobPreparation.initialize.LinkedListStructure;
import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import com.preppy.JobPreparation.pojos.LinkedListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SingleLLService {

    Logger logger = LoggerFactory.getLogger(SingleLLService.class);

    LinkedListNode head;
    public ResponseEntity<LinearDataStructureResponse> getList(){
        head = LinkedListStructure.getHead();
        List<Integer> ll = new ArrayList<>();
        LinkedListNode node = head;
        while(node != null){
            ll.add(node.getData());
            node = node.getNextNode();
        }
        LinearDataStructureResponse response = new LinearDataStructureResponse();
        response.setOperation("get list");
        response.setList(ll);
        if(ll.isEmpty()){
            response.setStatusCode(HttpStatusCode.valueOf(400));
            response.setResponse("List is empty");
        }else{
            response.setStatusCode(HttpStatusCode.valueOf(200));
            response.setResponse("List fetched");
        }
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    public ResponseEntity<LinearDataStructureResponse> insert(int value){
        LinkedListNode node = new LinkedListNode(value, null, null);
        head = LinkedListStructure.getHead();
        if(head == null){
            head = node;
            LinkedListStructure.setHead(head);
        }else{
            LinkedListNode ll = head;
            while(ll.getNextNode()!=null){
                ll = ll.getNextNode();
            }
            ll.setNextNode(node);
        }

        List<Integer> list = getAsList(head);

        LinearDataStructureResponse response = new LinearDataStructureResponse();
        response.setOperation("insert");
        response.setList(list);
        response.setStatusCode(HttpStatusCode.valueOf(200));
        response.setResponse("Value inserted: "+value);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> deleteFront(){
        if(LinkedListStructure.getHead() == null){
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "List is empty", null,
                            "delete first",
                            HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

        }

        int data = LinkedListStructure.getHead().getData();
        LinkedListNode newHead = LinkedListStructure.getHead().getNextNode();
        LinkedListStructure.setHead(newHead);
        head = newHead;
        return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "First value deleted: "+data, getAsList(newHead),
                        "delete first",
                        HttpStatusCode.valueOf(200)), HttpStatusCode.valueOf(200));
    }

   public ResponseEntity<LinearDataStructureResponse> deleteLast(){
       if(LinkedListStructure.getHead() == null){
           return new ResponseEntity<>(
                   new LinearDataStructureResponse(
                           "List is empty", null,
                           "delete first",
                           HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

       }


       LinearDataStructureResponse response = new LinearDataStructureResponse();

       response.setOperation("delete last");

       response.setStatusCode(HttpStatusCode.valueOf(200));
       if(LinkedListStructure.getHead().getNextNode() == null){
           LinkedListStructure.setHead(null);
           response.setResponse("Value deleted");
           head = null;
       }else {
           LinkedListNode node = head;
           while (node.getNextNode().getNextNode() != null) {
               node = node.getNextNode();
           }
           int data = node.getNextNode().getData();
           logger.info("Deleting the value: {}", data);
           node.setNextNode(null);
           response.setResponse("Value deleted at last: "+data);
       }
       response.setList(getAsList(head));
       return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> deletePosition(int position){

        if(LinkedListStructure.getHead() == null){
            return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "List is empty", null,
                        "delete position",
                        HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

         }

        List<Integer> llAsList = getAsList(head);
        if(position > llAsList.size()){
        return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "Invalid position", llAsList,
                        "delete position",
                        HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }


        LinearDataStructureResponse response = new LinearDataStructureResponse();

        response.setOperation("delete position");

        response.setStatusCode(HttpStatusCode.valueOf(200));
        if(LinkedListStructure.getHead().getNextNode() == null && position == 1){
            head = null;
            LinkedListStructure.setHead(null);
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "List emptied", null,
                            "delete position",
                            HttpStatusCode.valueOf(200)), HttpStatusCode.valueOf(200));
        }else if(position == 1){
            int value = head.getData();
            head = head.getNextNode();
            LinkedListStructure.setHead(head);
            response.setResponse("Value deleted at position: "+value);
        }else {
            LinkedListNode node = head;
            int count = 1;
            while (node.getNextNode().getNextNode() != null && count<position-1) {
                node = node.getNextNode();
                count++;
            }
            logger.info("Reached node is {}",node.getData());
            int data = node.getNextNode().getData();
            logger.info("Deleting the value: {}", data);
            node.setNextNode(node.getNextNode().getNextNode());
            response.setResponse("Value deleted at position: "+data);
        }
        response.setList(getAsList(head));
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    public List<Integer> getAsList(LinkedListNode node){
        List<Integer> ll = new ArrayList<>();
        while(node != null){
            ll.add(node.getData());
            node = node.getNextNode();
        }
        return ll;
    }
}
