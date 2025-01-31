package com.preppy.jobpreparation.controller;

import com.preppy.jobpreparation.service.sort.SortService;
import com.preppy.jobpreparation.pojos.SortRequest;
import com.preppy.jobpreparation.pojos.SortResponse;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sort")
public class SortController {
    Logger logger = LoggerFactory.getLogger(SortController.class);
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


    @PostConstruct
    public void printCreation(){
        logger.info("SortController created");
    }

    @PreDestroy
    public void printEnd(){
        logger.info("Sort controller scope is {}",(new AnnotationConfigApplicationContext("com.preppy").getBeanFactory().getBeanDefinition("sortController").getScope()));

        logger.info("SortController gonna be destroyed");
    }
}
