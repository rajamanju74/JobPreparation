package com.preppy.JobPreparation.Service.sort;

import com.preppy.JobPreparation.pojos.SortRequest;
import com.preppy.JobPreparation.pojos.SortResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class SortService {
    @Autowired
    SelectionSortService selectionSortService;

    @Autowired
    BubbleSortService bubbleSortService;

    @Autowired
    QuickSortService quickSortService;

    @Autowired
    MergeSortService mergeSortService;
    public ResponseEntity<SortResponse> doSort(SortRequest sortRequest){
        if(sortRequest.getMethod()=="selection") {
            return selectionSortService.sort(sortRequest);
        }else if(sortRequest.getMethod().equals("bubble")){
            return bubbleSortService.sort(sortRequest);
        }else if(sortRequest.getMethod().equals("merge")){
            return mergeSortService.sort(sortRequest);
        }
        else {
            return quickSortService.sort(sortRequest);
        }
    }

}
