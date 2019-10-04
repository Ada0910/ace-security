package com.ada.common.util;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ada
 * @ClassName :Query
 * @date 2019/10/4 17:20
 * @Description:
 */
@Getter
@Setter
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private int page = 1;
    private int limit = 10;

    public Query(Map<String, Object> params) {
        this.putAll(params);
        if (params.get("page") != null) {
            this.page = Integer.parseInt(params.get("page").toString());
            if (params.get("limit") != null) {
                this.limit = Integer.parseInt(params.get("limit").toString());
            }
            this.remove("page");
            this.remove("limit");
        }
    }
}
