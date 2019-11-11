package com.ada.tool.service;

import com.ada.api.vo.search.IndexObject;
import com.ada.common.response.TableResultResponse;

/**
 * @author Ada
 * @ClassName :LuceneService
 * @date 2019/11/10 13:50
 * @Description:
 */
public interface LuceneService {
    void save(IndexObject indexObject);

    void update(IndexObject indexObject);

    void delete(IndexObject indexObject);

    void deleteAll();

    TableResultResponse page(Integer pageNumber, Integer pageSize, String keyword);
}
