package com.ada.common.msg;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ada
 * @ClassName :TableData
 * @date 2019/10/4 17:16
 * @Description:
 */
@Getter
@Setter
class TableData<T> {
    long total;
    List<T> rows;

    public TableData(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public TableData() {
    }
}