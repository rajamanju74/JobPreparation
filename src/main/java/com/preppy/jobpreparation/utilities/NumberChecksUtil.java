package com.preppy.jobpreparation.utilities;

import com.preppy.jobpreparation.exception.InvalidInputException;
import org.springframework.http.HttpStatus;

public class NumberChecksUtil {
    public static void checkInputForNonZeroPositive(int number) throws Exception {
        if(number<=0){
            throw new InvalidInputException(HttpStatus.BAD_REQUEST.value(), "Provide non zero positive number");
        }
    }
}
