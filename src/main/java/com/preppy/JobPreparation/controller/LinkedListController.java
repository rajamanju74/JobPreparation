package com.preppy.JobPreparation.controller;

import com.preppy.JobPreparation.Service.SingleLinkedList.SingleLinkedListVersions;
import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linkedList/singly/{version}")
public class LinkedListController {
    @Autowired
    SingleLinkedListVersions singleLinkedListVersions;

    @GetMapping
    public void getVersion(@PathVariable("version") String version){

    }
    @GetMapping("/getList")
    public ResponseEntity<LinearDataStructureResponse> getList(@PathVariable("version") String version){
        return singleLinkedListVersions.getList(version);
    }

    @PostMapping("/insert/{value}")
    public ResponseEntity<LinearDataStructureResponse> insert(
            @PathVariable("version") String version, @PathVariable int value){
        return singleLinkedListVersions.insert(version, value);
    }

    @DeleteMapping("/deleteFront")
    public ResponseEntity<LinearDataStructureResponse> deleteFront(
            @PathVariable("version") String version){
        return singleLinkedListVersions.deleteFront(version);
    }

    @DeleteMapping("/deleteLast")
    public ResponseEntity<LinearDataStructureResponse> deleteLast(
            @PathVariable("version") String version){
        return singleLinkedListVersions.deleteLast(version);
    }
}
