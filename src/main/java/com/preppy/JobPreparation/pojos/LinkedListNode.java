package com.preppy.JobPreparation.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkedListNode {
    int data;
    LinkedListNode nextNode;
    LinkedListNode beforeNode;
}
