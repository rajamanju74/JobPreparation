package com.preppy.JobPreparation.Service.SingleLinkedList;

import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SingleLinkedListVersions {
    @Autowired
    SingleLLService singleLLService;
    @Autowired
    SinglyLLServiceV2 singlyLLServiceV2;
    public ResponseEntity<LinearDataStructureResponse> getList(String version){
        if(version.equals("v1")){
            return singleLLService.getList();
        }
        else if(version.equals("v2")){
            return singlyLLServiceV2.getList();
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
            if(version.equals("v1")) {
                return singleLLService.insert(value);
            }
            else{
                return singlyLLServiceV2.insert(value);
            }
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "insert", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public ResponseEntity<LinearDataStructureResponse> deleteFront (String version){
        if(checkVersion(version)){
            if(version.equals("v1")) {
                return singleLLService.deleteFront();
            }else{
                return singlyLLServiceV2.deleteFront();
            }
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "delete front", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public ResponseEntity<LinearDataStructureResponse> deleteLast (String version){
        if(checkVersion(version)){
            if(version.equals("v1")) {
                return singleLLService.deleteLast();
            }else{
                return singlyLLServiceV2.deleteLast();
            }
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "delete front", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }

    public boolean checkVersion(String version){
        if(version.equals("v1") || version.equals("v2")){
            return true;
        }
        return false;
    }

    public ResponseEntity<LinearDataStructureResponse> deletePosition (String version, int position){
        if(checkVersion(version)){
            if(version.equals("v1")) {
                return singleLLService.deletePosition(position);
            }else{
                return singlyLLServiceV2.deletePosition(position);
            }
        }else{
            return new ResponseEntity<>(new LinearDataStructureResponse("Invalid version", null, "delete front", HttpStatusCode.valueOf(400)), HttpStatusCode.valueOf(400));
        }
    }
}
