package com.preppy.JobPreparation.Service.SingleLinkedList;

import com.preppy.JobPreparation.initialize.LinkedListStructure;
import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SinglyLLServiceV2 {


    public ResponseEntity<LinearDataStructureResponse> getList(){

        List<Integer> ll = LinkedListStructure.getList();
        LinearDataStructureResponse response = new LinearDataStructureResponse();
        response.setOperation("get list");
        response.setList(ll);
        if(ll == null || ll.isEmpty()){
            response.setStatusCode(HttpStatusCode.valueOf(400));
            response.setResponse("List is empty");
        }else{
            response.setStatusCode(HttpStatusCode.valueOf(200));
            response.setResponse("List fetched");
        }
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    public ResponseEntity<LinearDataStructureResponse> insert(int value){
        if(LinkedListStructure.getList() == null){
            LinkedListStructure.setList(new LinkedList<>());
        }

        LinkedListStructure.getList().add(value);
        LinearDataStructureResponse response = new LinearDataStructureResponse();
        response.setOperation("insert");
        response.setList(LinkedListStructure.getList());
        response.setStatusCode(HttpStatusCode.valueOf(200));
        response.setResponse("Value inserted: "+value);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> deleteFront(){
        if(LinkedListStructure.getList() == null){
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "List is empty", null,
                            "delete first",
                            HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

        }
        LinkedListStructure.getList().removeFirst();
        return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "First value deleted", LinkedListStructure.getList(),
                        "delete first",
                        HttpStatusCode.valueOf(200)), HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> deleteLast(){
        if(LinkedListStructure.getList() == null){
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "List is empty", null,
                            "delete last",
                            HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

        }
        LinkedListStructure.getList().removeLast();
        return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "First value deleted", LinkedListStructure.getList(),
                        "delete last",
                        HttpStatusCode.valueOf(200)), HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> deletePosition(int position){
        if(LinkedListStructure.getList() == null){
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "List is empty", null,
                            "delete position",
                            HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));

        }
        if(position > LinkedListStructure.getList().size() || position<=0){
            return new ResponseEntity<>(
                    new LinearDataStructureResponse(
                            "Invalid position", LinkedListStructure.getList(),
                            "delete position",
                            HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
        LinkedListStructure.getList().remove(position-1);

        return new ResponseEntity<>(
                new LinearDataStructureResponse(
                        "value at position deleted", LinkedListStructure.getList(),
                        "delete at",
                        HttpStatusCode.valueOf(200)), HttpStatusCode.valueOf(200));
    }
}
