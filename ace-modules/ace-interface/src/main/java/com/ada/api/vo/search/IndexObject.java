package com.ada.api.vo.search;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Ada
 * @ClassName :IndexObject
 * @date 2019/10/3 11:31
 * @Description:
 */
@Getter
@Setter
public class IndexObject implements Comparable<IndexObject>, Serializable {
    private Long id;
    private String title;
    private String keywords;
    private String descripton;
    private String postDate;
    private String url;

    /*相似度*/
    private float score;

    public IndexObject() {
        super();
    }

    public IndexObject(Long _id, String _keywords, String _descripton, String _postDate, float _score) {
        super();
        this.id = _id;
        this.keywords = _keywords;
        this.score = _score;
        this.descripton = _descripton;
        this.postDate = _postDate;
    }

    @Override
    public int compareTo(IndexObject o) {
        if (this.score < o.getScore()) {
            return 1;
        } else if (this.score > o.getScore()) {
            return -1;
        }
        return 0;
    }
}
