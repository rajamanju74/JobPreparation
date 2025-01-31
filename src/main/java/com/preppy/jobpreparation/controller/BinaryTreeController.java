package com.preppy.jobpreparation.controller;

import com.preppy.jobpreparation.service.BinaryTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/binarytree")
public class BinaryTreeController {
    @Autowired
    BinaryTreeService service;
    @PostMapping("/{data}")
    public void insert(@PathVariable int data){
        service.insert(data);
    }
    @GetMapping
    public  void getTree(){
        service.getDFS();
    }
}
