package com.ada.admin.vo;

import com.ada.common.vo.TreeNode;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName:GroupTree
 * @author: Ada
 * @date 2019/09/29 17:44
 * @Description:
 */
@Setter
@Getter
public class GroupTree extends TreeNode {
    String label;
    String name;
}
