package com.preppy.jobpreparation.service;

import com.preppy.jobpreparation.pojos.LinearDataStructureResponse;
import com.preppy.jobpreparation.initialize.QueueStructure;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class QueueService {

    QueueStructure queueStructure;

    QueueService(){
        this.queueStructure = QueueStructure.getQueue();
    }

    public ResponseEntity<LinearDataStructureResponse> getQueue(){
        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setOperation("Get Queue");
        queueResponse.setList(queueStructure.queue);

        if(queueStructure.queue.isEmpty()){
            queueResponse.setResponse("Queue is empty");
            queueResponse.setStatusCode(HttpStatusCode.valueOf(400));
            return ResponseEntity.badRequest().body(queueResponse);
        }
        queueResponse.setResponse("Queue returned successfully");
        queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(queueResponse, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> enqueue(int value){
        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();

        queueStructure.queue.add(value);

        queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
        queueResponse.setResponse("Enqueued value "+value+" at the end");
        queueResponse.setList(queueStructure.queue);
        queueResponse.setOperation("enqueue");

        return ResponseEntity.accepted().body(queueResponse);
    }

    public ResponseEntity<LinearDataStructureResponse> dequeue(){

        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setOperation("dequeue");
        int size = queueStructure.queue.size();
        try {
            int dequeuedValue = queueStructure.queue.get(0);
            queueStructure.queue.remove(0);
            queueResponse.setList(queueStructure.queue);
            queueResponse.setResponse("Dequeued value is "+ dequeuedValue);
            queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(200));
        }catch(IndexOutOfBoundsException e){
            queueResponse.setList(queueStructure.queue);
            queueResponse.setResponse("Queue is empty");
            queueResponse.setStatusCode(HttpStatusCode.valueOf(400));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(400));
        }

    }

}
