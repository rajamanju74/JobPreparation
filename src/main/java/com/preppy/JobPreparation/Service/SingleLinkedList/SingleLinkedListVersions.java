package com.preppy.JobPreparation.Service.SingleLinkedList;

import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import com.preppy.JobPreparation.pojos.LinkedListNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class SingleLinkedListVersions {
    @Autowired
    SingleLLService singleLLService;
    public ResponseEntity<LinearDataStructureResponse> getList(String version){
        if(version.equals("v1")){
            return singleLLService.getList();
        }
        LinearDataStructureResponse response =  new LinearDataStructureResponse
                ("Invalid version", null, "get list",
                        HttpStatusCode.valueOf(400)
                );
        return new ResponseEntity<>(response,
                HttpStatusCode.valueOf(400)
        );
    }

    public ResponseEntity<LinearDataStructureResponse> insert (String version, int value){
        if(checkVersion(version)){
            return singleLLService.insert(value);
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "insert", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public ResponseEntity<LinearDataStructureResponse> deleteFront (String version){
        if(checkVersion(version)){
            return singleLLService.deleteFront();
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "delete front", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public ResponseEntity<LinearDataStructureResponse> deleteLast (String version){
        if(checkVersion(version)){
            return singleLLService.deleteLast();
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "delete front", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public boolean checkVersion(String version){
        if(version.equals("v1")){
            return true;
        }
        return false;
    }
}
