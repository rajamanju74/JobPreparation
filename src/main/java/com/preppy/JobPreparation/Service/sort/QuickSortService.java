package com.preppy.JobPreparation.Service.sort;

import com.preppy.JobPreparation.pojos.SortRequest;
import com.preppy.JobPreparation.pojos.SortResponse;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.swap;

@Service
public class QuickSortService {
    List<String> record;



    /*
     * LOGIC
     *
     *
     * //if j value is greater no need to swap
    //if j value is less than the pivot, then swap it with i
    *
    *
    * say array is 1 7 8 9 10 5 quicksort(arr, 0, 5)
    * first iteration pivot location is 5, value is 5 (considering last value)
    *
    * i = -1, j = 0
    *
    * (NOTE - always i <= j)
    *
    * for j = 0; value 1 --> 1<5 then swap (i+1,j)  -> swap (0,0) --> no change
    * 1 7 8 9 10
    * for j = 1; value = 7 --> 7>5 then nothing to do (only swap small values to left)
    * for j = 2; value = 8 --> 8>5 nothing to do
    * for j = 3; value = 9 --> 9>5 nothing to do
    * for j = 4; value = 10 --> 10>5 nothing to do
    *
    * Now the array looks like this 1 7 8 9 10 5 -> pivot = 5, i = 1
    * swap pivot, i+1
    * 1 5 8 9 10 7
    *
    * pi = 1
    * quicksort(arr, 0, 0) -> nothing done
    * quicksort(arr, 2, 5)
    * sort  8 9 10 7
    * index 2 3  4 5
    * pivot = 5, i = 1, j = 2
    * all values are greater than 7 --> no swappings
    * just swap pivot, i+1 swap (2, 5)
    * result 7 9 10 8
    * thus array looks 1 5 7 9 10 8
    * quickSort(2,2) and quickSort(3, 5)
    * quicksort(3,5) -> 9 10 8 -> 8 10 9 -> i+1 will be 3
    * 1 5 7 8 10 9
    * quicksort(3,2)- invalid and quicksort(4,5)
    * 10 9 --> sort 9 10 --> i+1 = 4
    * 1 5 7 8 9 10
    * quicksort(4,3) and quicksort(5,5)  --> stops
    *
    *
    * */
    //Logger logger = LoggerFactory.getLogger(QuickSortService.class);
    public ResponseEntity<SortResponse> sort(SortRequest request){
        SortResponse response = doQuickSort(request);
        return new ResponseEntity<>(response, response.getStatus());
    }

    private SortResponse doQuickSort(SortRequest request) {

    record = new ArrayList<>();
    SortResponse response = new SortResponse();
    response.setInputArray(new ArrayList<>(request.getGivenArray()));
    quickSort(request.getGivenArray(), 0, request.getGivenArray().size()-1);


    String logs = String.join("\n",record);
    response.setMessage("Sorted and comments are : "+ logs);
    response.setSortedArray(request.getGivenArray());
    response.setMethod("quick sort");
    response.setStatus(HttpStatusCode.valueOf(200));
    return response;
    }

    private void quickSort(List<Integer> arr, int left, int right) {
        if(left<right) {
            int pivot = partition(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private int partition(List<Integer> arr, int left, int right) {
        int pi = arr.get(right);
        //int j = left;
        int i = left-1;

        for(int j = left; j<right;j++){
            if(arr.get(j)<pi){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, right, i+1);
        record.add("Partition function ("+left+","+right+") ended with list: "+arr );
        return i+1;
    }
}
