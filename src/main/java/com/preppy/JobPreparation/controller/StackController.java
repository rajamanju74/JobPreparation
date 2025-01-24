package com.preppy.JobPreparation.controller;

import com.preppy.JobPreparation.Service.StackService;
import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stack")
public class StackController {
    public static final Logger logger = LoggerFactory.getLogger(StackController.class);
    @Autowired
    StackService stackService;

    @GetMapping("/about")
    public ResponseEntity<LinearDataStructureResponse> getAbout(){
        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
        queueResponse.setOperation("description");
        queueResponse.setList(null);
        queueResponse.setResponse("Stack is Last In First Out approach data structure.");
        return new ResponseEntity<>(queueResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/show")
    public ResponseEntity<LinearDataStructureResponse> getQueue(){
        logger.info("Request to get stack");
        return stackService.getStack();
    }


    @PostMapping("/{value}")
    public ResponseEntity<LinearDataStructureResponse> push(@PathVariable int value){
        logger.info("Request to push {}", value);
        return stackService.push(value);
    }

    @DeleteMapping("/pop")
    public ResponseEntity<LinearDataStructureResponse> pop(){
        logger.info("Request to pop");
        return stackService.pop();
    }

    @GetMapping("/peek")
    public ResponseEntity<LinearDataStructureResponse> peek(){
        logger.info("Request to peek");
        return stackService.peek();
    }
}
