package com.ada.generator.mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:GeneratorMapper
 * @author: Ada
 * @date 2019/11/07 16:17
 * @Description: 代码生成器
 */
public interface GeneratorMapper {

    List<Map<String, Object>> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}

