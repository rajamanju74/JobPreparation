package com.preppy.jobpreparation.service.sort;

import com.preppy.jobpreparation.pojos.SortRequest;
import com.preppy.jobpreparation.pojos.SortResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeSortService {

    /*
    * logic:
    *  1, 7, 8, 9, 10, 5
    *
    *  split
    *                    [0,5]
    *                   /     \
    *              [0,2]        [3,5]
    *             /     \       /    \
    *        [0,1]   [2,2]    [3,4]   [5,5]
    *        /   \
    *    [0,0]   [1,1]
    *
    *
    * 1, 7, 8, 9, 10, 5
    *                                           [1 7 8 9 10 5]
    *
    *                               [1 7 8]                   [9 10 5]
    *                           [1 7]       [8]              [9 10]   [5]
    *                       [1]     [7]                     [9] [10]
    * Now merge
    * call main left
    * [1][7]  ---> [1,7]
    * [1,7] [8] ----> [1,7,8]
    * call main right
    * [9] [10] ---> [9,10]
    * [9,10] [5] ----> [5,9,10]
    * last merge call
    * [1,7,8] [5,9,10] ----> [1,5,7,8,9,10]
    *
    * */
    int[] arr;
    Logger logger = LoggerFactory.getLogger(MergeSortService.class);
    public ResponseEntity<SortResponse> sort(SortRequest request){
        SortResponse response = doMergeSort(request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    private SortResponse doMergeSort(SortRequest request) {
        SortResponse response = new SortResponse();
        response.setInputArray(new ArrayList<>(request.getGivenArray()));
        response.setMethod("merge");

        arr = new int[request.getGivenArray().size()];
        String input = "";
        for(int i = 0;i<arr.length;i++){
            arr[i] = request.getGivenArray().get(i);
            input = input+arr[i]+" ";

        }
        logger.info("input as array: {}", input);
        List<Integer> list = request.getGivenArray();
        mergeSort(0, arr.length-1);
        input = "";
        for(int i = 0;i<arr.length;i++){
            input = input+arr[i]+" ";
        }
        logger.info("Output as array: {}", input);

        response.setStatus(HttpStatusCode.valueOf(200));
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            result.add(arr[i]);
        }
        response.setSortedArray(result);
        return response;
    }

    private void mergeSort(int l, int r){
        if(l>=0 && l<r){
            int mid = l + ((r-l)/2);
            logger.info("Mid = {}", mid);

            //logger.info("Calling with l = {}, r = {}", l, mid);
            mergeSort(l, mid);
            //logger.info("Calling with l = {}, r = {}", (mid+1), r);
            mergeSort(mid+1, r);

            merge(l, mid, r);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] leftarr = new int[mid-left+1];

        for(int i = 0;i<leftarr.length;i++){
            leftarr[i] = arr[left+i];
        }

        int[] rightarr = new int[right-mid];
        for(int i = 0; i<rightarr.length;i++){
            rightarr[i] = arr[mid+1+i];
        }

        int lp = 0, rp = 0;
        int k = left;

        while(lp<leftarr.length && rp<rightarr.length){
            if(leftarr[lp] <= rightarr[rp]){
                arr[k] = leftarr[lp];
                lp++;
            }else{
                arr[k] = rightarr[rp];
                rp++;
            }
            k++;
        }

        while(lp<leftarr.length){
            arr[k] = leftarr[lp];
            lp++;
            k++;
        }
        while(rp<rightarr.length){
            arr[k] = rightarr[rp];
            rp++;
            k++;
        }
    }

}
