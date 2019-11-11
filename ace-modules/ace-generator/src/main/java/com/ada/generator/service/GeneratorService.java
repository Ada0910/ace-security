package com.ada.generator.service;

import com.ada.generator.mapper.GeneratorMapper;
import com.ada.generator.util.GeneratorUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @ClassName:GeneratorService
 * @author: Ada
 * @date 2019/11/07 16:13
 * @Description:
 */
@Service
public class GeneratorService {
    @Autowired
    private GeneratorMapper generatorMapper;

    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        int offset = Integer.parseInt(map.get("offset").toString());
        int limit = Integer.parseInt(map.get("limit").toString());
        map.put("offset", offset);
        map.put("limit", limit);
        return generatorMapper.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return generatorMapper.queryTotal(map);
    }

    public Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }

    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GeneratorUtil.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }


}
