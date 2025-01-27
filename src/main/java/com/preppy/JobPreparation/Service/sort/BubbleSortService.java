package com.preppy.JobPreparation.Service.sort;

import com.preppy.JobPreparation.pojos.SortRequest;
import com.preppy.JobPreparation.pojos.SortResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BubbleSortService {
    Logger logger = LoggerFactory.getLogger(BubbleSortService.class);
    public ResponseEntity<SortResponse> sort(SortRequest request){
        SortResponse response = doBubbleSort(request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    private SortResponse doBubbleSort(SortRequest request) {
        List<Integer> list = request.getGivenArray();
        logger.info("Given array: {}", list);
        logger.info("List size: {}",list.size());
        SortResponse response = new SortResponse();

        response.setInputArray(new ArrayList<>(list));
        for(int i = 0; i<list.size()-1;i++){
            for(int j = 0; j < list.size()-i-1;j++){
                logger.info("i: {}, j: {}", i, j);
                if(list.get(j)>list.get(j+1)){
                    swap(list, j, j+1);
                }
            }
            logger.info("Array after each iteration: {}", list);
        }
        response.setMethod("bubble");
        response.setStatus(HttpStatusCode.valueOf(200));
        response.setSortedArray(list);
        response.setMessage("sorted");
        return response;
    }

    public void swap(List<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
