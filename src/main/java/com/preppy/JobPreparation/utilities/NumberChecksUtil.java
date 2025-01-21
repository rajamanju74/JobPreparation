package com.preppy.JobPreparation.utilities;

import com.preppy.JobPreparation.exception.InvalidInputException;
import org.springframework.http.HttpStatus;

public class NumberChecksUtil {
    public static InvalidInputException checkInputForNonZeroPositive(int number) throws Exception {
        if(number<=0){
            throw new InvalidInputException(HttpStatus.BAD_REQUEST.value(), "Provide non zero positive number");
        }
        return null;
    }
}
