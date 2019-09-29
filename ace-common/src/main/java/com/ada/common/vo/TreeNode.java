package com.ada.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:TreeNode
 * @author: Ada
 * @date 2019/09/29 17:28
 * @Description:
 */
@Setter
@Getter
public class TreeNode {
    protected int id;
    protected int parentId;
    List<TreeNode> children = new ArrayList<TreeNode>();
}
