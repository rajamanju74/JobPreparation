package com.preppy.jobpreparation.service.sort;

import com.preppy.jobpreparation.pojos.SortRequest;
import com.preppy.jobpreparation.pojos.SortResponse;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InsertionSortService {
    Logger logger = LoggerFactory.getLogger(InsertionSortService.class);
    public ResponseEntity<SortResponse> sort(SortRequest request){
        SortResponse response = doInsertionSort(request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    private SortResponse doInsertionSort(SortRequest request) {
        SortResponse response = new SortResponse();
        response.setMethod("Insertion");
        response.setInputArray(new ArrayList<>(request.getGivenArray()));

        List<Integer> arr = request.getGivenArray();
        StringBuilder steps = new StringBuilder(arr.toString() + " \n");
        int n = arr.size();
        for(int i = 1; i<n; i++){
            int e = arr.get(i);
            arr.set(i, arr.get(i-1));
            boolean flag = false;
            for(int j = i-1; j>=0 && !flag; j--){
                if(e<=arr.get(j)){
                    //move the array to right
                    //arr[j+1] = arr[j]
                    arr.set(j+1, arr.get(j));
                }else{
                    //e>arr.get(j)
                    //insert the value
                    arr.set(j+1, e);
                    flag = true;
                }
            }

            if(!flag){
                arr.set(0,e);
            }

            steps.append(arr.toString()).append(" \n");
        }

        response.setMessage("Steps: "+steps);
        response.setSortedArray(arr);
        response.setStatus(HttpStatusCode.valueOf(200));
        return response;
    }
    @PostConstruct
    public void printCreation(){
        logger.info("Bean created");
    }

    @PreDestroy
    public void beforeDestory(){
        logger.info("Bean gonna be destroyed");
    }
}
