package com.preppy.jobpreparation.service;

import com.preppy.jobpreparation.exception.InvalidInputException;
import com.preppy.jobpreparation.pojos.SequenceResponse;
import com.preppy.jobpreparation.pojos.SequenceType;
import com.preppy.jobpreparation.utilities.NumberChecksUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*public abstract class Class1{

}

 */
@Service
public class SequenceService {

    public SequenceResponse fibonacciSequence(int number) throws Exception {
        SequenceResponse sequenceResponse = new SequenceResponse();
        sequenceResponse.setSequenceType(SequenceType.FIBONACCI.getSequence());

        try{
            NumberChecksUtil.checkInputForNonZeroPositive(number);
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
