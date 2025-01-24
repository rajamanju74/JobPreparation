package com.preppy.JobPreparation.Service;

import com.preppy.JobPreparation.initialize.StackStructure;
import com.preppy.JobPreparation.pojos.LinearDataStructureResponse;
import com.preppy.JobPreparation.initialize.QueueStructure;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StackService {

    StackStructure stackStructure;
    List<Integer> stack;

    StackService(){
        this.stackStructure = StackStructure.getStack();
        this.stack = stackStructure.stack;
    }

    public ResponseEntity<LinearDataStructureResponse> getStack(){
        LinearDataStructureResponse stackResponse = new LinearDataStructureResponse();
        stackResponse.setOperation("Get Stack");
        stackResponse.setList(stack);
        if(stack.isEmpty()){
            stackResponse.setResponse("Stack is empty");
            stackResponse.setStatusCode(HttpStatusCode.valueOf(400));
            return ResponseEntity.badRequest().body(stackResponse);
        }
        stackResponse.setResponse("Queue returned successfully");
        stackResponse.setStatusCode(HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(stackResponse, HttpStatusCode.valueOf(200));
    }

    public ResponseEntity<LinearDataStructureResponse> push(int value){
        LinearDataStructureResponse stackResponse = new LinearDataStructureResponse();

        stack.add(value);

        stackResponse.setStatusCode(HttpStatusCode.valueOf(200));
        stackResponse.setResponse("pushed "+value+" at the end");
        stackResponse.setList(stack);
        stackResponse.setOperation("push");

        return ResponseEntity.accepted().body(stackResponse);
    }

    public ResponseEntity<LinearDataStructureResponse> pop(){

        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setOperation("pop");
        int size = stack.size();
        try {
            int popValue = stack.get(size - 1);
            stack.remove(size - 1);
            queueResponse.setList(stack);
            queueResponse.setResponse("popped value is "+ popValue);
            queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(200));
        }catch(IndexOutOfBoundsException e){
            queueResponse.setList(stack);
            queueResponse.setResponse("Stack is empty");
            queueResponse.setStatusCode(HttpStatusCode.valueOf(400));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(400));
        }

    }

    public ResponseEntity<LinearDataStructureResponse> peek(){

        LinearDataStructureResponse queueResponse = new LinearDataStructureResponse();
        queueResponse.setOperation("peek");
        int size = stack.size();
        try {
            int peekValue = stack.get(size - 1);
            //stack.remove(size - 1);
            queueResponse.setList(stack);
            queueResponse.setResponse("Next value to pop is "+ peekValue);
            queueResponse.setStatusCode(HttpStatusCode.valueOf(200));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(200));
        }catch(IndexOutOfBoundsException e){
            queueResponse.setList(stack);
            queueResponse.setResponse("Stack is empty");
            queueResponse.setStatusCode(HttpStatusCode.valueOf(400));
            return new ResponseEntity<>(queueResponse,HttpStatusCode.valueOf(400));
        }

    }
}
