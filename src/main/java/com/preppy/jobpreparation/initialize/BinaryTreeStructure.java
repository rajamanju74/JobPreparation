package com.preppy.jobpreparation.initialize;

import com.preppy.jobpreparation.pojos.BinaryTreeNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class BinaryTreeStructure {
    @Getter
    @Setter
    private BinaryTreeNode root;
}
