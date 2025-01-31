package com.preppy.jobpreparation.controller;

import com.preppy.jobpreparation.service.QueueService;
import com.preppy.jobpreparation.pojos.LinearDataStructureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {
    public static final Logger logger = LoggerFactory.getLogger(QueueController.class);
    @Autowired
    QueueService queueService;

    @GetMapping("/about")
    public ResponseEntity<LinearDataStructureResponse> getAbout(){
        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
        queueResponse.setOperation("description");
        queueResponse.setList(null);
        queueResponse.setResponse("Queue is First In First Out approach data structure. \n " +
                "which is used in many applications in managing tasks, scheduling processes, message handling like in kafka, google pub/sub.");
        return new ResponseEntity<>(queueResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/show")
    public ResponseEntity<LinearDataStructureResponse> getQueue(){
        logger.info("Request to get queue");
        return queueService.getQueue();
    }


    @PostMapping("/{value}")
    public ResponseEntity<LinearDataStructureResponse> enqueue(@PathVariable int value){
        logger.info("Request to insert {}", value);
        return queueService.enqueue(value);
    }

    @DeleteMapping("/dequeue")
    public ResponseEntity<LinearDataStructureResponse> dequeue(){
        logger.info("Request to dequeue");
        return queueService.dequeue();
    }
}
