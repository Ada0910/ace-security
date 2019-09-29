package com.ada.admin.vo;

import com.ada.common.vo.TreeNode;
import lombok.Getter;
import lombok.Setter;


/**
 * @ClassName:MenuTree
 * @author: Ada
 * @date 2019/09/29 16:51
 * @Description:
 */
@Getter
@Setter
public class MenuTree extends TreeNode {
    String icon;
    String title;
    String href;
    boolean spread = false;
    String path;
    String component;
    String authority;
    String redirect;
    String code;
    String type;
    String label;

    public MenuTree() {
    }

    public MenuTree(int id, String name, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.title = name;
        this.label = name;
    }

    public MenuTree(int id, String name, MenuTree parent) {
        this.id = id;
        this.parentId = parent.getId();
        this.title = name;
        this.label = name;
    }
}
