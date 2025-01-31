package com.preppy.jobpreparation.initialize;

import com.preppy.jobpreparation.pojos.BinaryTreeNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TreeConfig {

    @Bean("binaryTree")
    public BinaryTreeStructure binaryTree(){
        return new BinaryTreeStructure();
    }

    @Bean("binarySearchTree")
    public BinaryTreeStructure binarySearchTree(){
        return new BinaryTreeStructure();
    }
}
