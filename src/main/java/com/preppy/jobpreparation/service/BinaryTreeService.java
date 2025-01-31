package com.preppy.jobpreparation.service;

import com.preppy.jobpreparation.initialize.BinaryTreeStructure;
import com.preppy.jobpreparation.pojos.BinaryTreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class BinaryTreeService {
    @Autowired
    @Qualifier("binaryTree")
    BinaryTreeStructure tree;
    Logger logger = LoggerFactory.getLogger(BinaryTreeService.class);
    public void insert(int data){
        BinaryTreeNode newNode = new BinaryTreeNode(data, null, null);
        if(tree.getRoot() == null){
            logger.info("Root is set");
            tree.setRoot(newNode);
        }
        else{
            insertIntoTree(newNode, tree.getRoot());
        }
    }

    private void insertIntoTree(BinaryTreeNode newNode, BinaryTreeNode root) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            BinaryTreeNode front = q.peek();
            if(front.getLeft() == null){
                front.setLeft(newNode);
                break;
            }else if(front.getRight() == null){
                front.setRight(newNode);
                break;
            }else{
                q.remove();
            }

            if(front.getLeft()!=null){
                q.add(front.getLeft());
            }if(front.getRight()!=null){
                q.add(front.getRight());
            }
        }
    }


    public void getDFS(){
        if(tree.getRoot()!=null){
        logger.info("Inorder traversal: ");
        inOrderTraverse(tree.getRoot());
        logger.info("preorder traversal: ");
        preOrderTraverse(tree.getRoot());
        logger.info("post order traversal: ");
        postOrderTraverse(tree.getRoot());

        }
        else{
            logger.info("Get tree: Root is null");
        }
    }

    private void postOrderTraverse(BinaryTreeNode root){
        if(root == null){
            return;
        }
        postOrderTraverse(root.getLeft());
        postOrderTraverse(root.getRight());
        logger.info("Value: {}", root.getData());

    }

    private void preOrderTraverse(BinaryTreeNode root){
        if(root == null){
            return;
        }
        logger.info("Value: {}", root.getData());
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }

    private void inOrderTraverse(BinaryTreeNode root){
        if(root == null){
            return;
        }
        inOrderTraverse(root.getLeft());
        logger.info("Value: {}", root.getData());
        inOrderTraverse(root.getRight());
    }

}
