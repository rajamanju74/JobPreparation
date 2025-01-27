package com.preppy.JobPreparation.controller;

import com.preppy.JobPreparation.Service.sort.SortService;
import com.preppy.JobPreparation.pojos.SortRequest;
import com.preppy.JobPreparation.pojos.SortResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sort")
public class SortController {
    /*
    * TODO:
    *  Selection sort
    *  Bubble sort
    *  Heap sort
    *  Quick sort
    *  Log the logic
    * */

    @Autowired
    SortService sortService;
    @GetMapping
    public ResponseEntity<SortResponse> doSort(@RequestBody SortRequest sortRequest){
        return sortService.doSort(sortRequest);
    }
}
