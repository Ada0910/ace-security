package com.ada.admin.vo;

import com.ada.common.vo.TreeNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ada
 * @ClassName :AuthorityMenuTree
 * @date 2019/10/3 11:05
 * @Description:
 */
@Getter
@Setter
public class AuthorityMenuTree extends TreeNode implements Serializable {
    String text;

    List<AuthorityMenuTree> nodes = new ArrayList<AuthorityMenuTree>();

    String icon;

    public AuthorityMenuTree(String text, List<AuthorityMenuTree> nodes) {
        this.text = text;
        this.nodes = nodes;
    }

    public AuthorityMenuTree() {
    }

    @Override
    public void add(TreeNode node) {
        super.add(node);
        AuthorityMenuTree n = new AuthorityMenuTree();
        BeanUtils.copyProperties(node, n);
        nodes.add(n);
    }
}
