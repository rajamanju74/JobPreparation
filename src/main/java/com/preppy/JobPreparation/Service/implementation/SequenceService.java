package com.preppy.JobPreparation.Service.implementation;

import com.preppy.JobPreparation.exception.InvalidInputException;
import com.preppy.JobPreparation.pojos.SequenceResponse;
import com.preppy.JobPreparation.pojos.SequenceType;
import com.preppy.JobPreparation.utilities.NumberChecksUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SequenceService {
    public NumberChecksUtil numberChecksUtil;

    public SequenceResponse fibonacciSequence(int number) throws Exception {
        SequenceResponse sequenceResponse = new SequenceResponse();
        sequenceResponse.setSequenceType(SequenceType.FIBONACCI.getSequence());

        try{
            numberChecksUtil.checkInputForNonZeroPositive(number);
            if(number>20){
                throw new Exception("Provide smaller number");
            }
        }catch(InvalidInputException e){
            //throw new IllegalArgumentException("Error in input "+sequenceResponse);
            throw new InvalidInputException(e.getErrorCode(), "Invalid input: "+e.getMessage());
        }catch(Exception e){
            throw new Exception("Large input");
        }

        sequenceResponse.setStatus("Success");
        sequenceResponse.setNumber(number);
        List<Integer> fibSequence = new ArrayList<>();
        fibSequence.add(0);
        if(number==1){
            sequenceResponse.setSequence(fibSequence);
            return sequenceResponse;
        }
        fibSequence.add(1);
        String result = "";

        result+=fibSequence.get(0)+"\n"+fibSequence.get(1)+"\n";
        for(int i = 2; i<number; i++) {
            fibSequence.add(fibSequence.get(i-1)+fibSequence.get(i-2));
            result+=fibSequence.get(i)+"\n";
        }

        sequenceResponse.setSequence(fibSequence);
        return sequenceResponse;
    }
}
