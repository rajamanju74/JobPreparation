package com.preppy.jobpreparation.controller;

import com.preppy.jobpreparation.service.SequenceService;
import com.preppy.jobpreparation.exception.InvalidInputException;
import com.preppy.jobpreparation.pojos.SequenceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sequences")
public class SequencesController {

    @Autowired
    public SequenceService sequenceService;
    @GetMapping("/")
    public String Hello(){
        return "HelloWorld";
    }
    @GetMapping("/{number}")
    public String returnVal(@PathVariable String number){
        return number;
    }
    @GetMapping("/fibonacci/{number}")
    @ResponseBody
    public ResponseEntity<SequenceResponse> getFibonacciSequence(@PathVariable int number) throws Exception {
        SequenceResponse response = null;
        try {
            response = sequenceService.fibonacciSequence(number);
            return ResponseEntity.ok(sequenceService.fibonacciSequence(number));
        } catch (InvalidInputException e) {
            response = new SequenceResponse(null, number, "Fibonacci", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch(Exception e){
            response = new SequenceResponse(null, number, "Fibonacci", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
