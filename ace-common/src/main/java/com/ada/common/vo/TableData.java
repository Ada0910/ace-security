package com.ada.common.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Ada
 * @ClassName :TableData
 * @date 2019/10/4 17:16
 * @Description:获取表格的总条数和行数
 */
@Getter
@Setter
public class TableData<T> {
    long total;
    List<T> rows;

    public TableData(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public TableData() {
    }
}