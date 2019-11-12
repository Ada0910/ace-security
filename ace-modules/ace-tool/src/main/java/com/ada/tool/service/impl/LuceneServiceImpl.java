package com.ada.tool.service.impl;

import com.ada.api.vo.search.IndexObject;
import com.ada.common.response.TableResultResponse;
import com.ada.tool.dao.LuceneDao;
import com.ada.tool.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ada
 * @ClassName :LuceneServiceImpl
 * @date 2019/11/10 13:51
 * @Description:
 */
@Service
public class LuceneServiceImpl implements LuceneService {
    @Autowired
    private LuceneDao luceneDao;


    @Override
    public void save(IndexObject indexObject) {
        luceneDao.create(indexObject);
    }


    @Override
    public void update(IndexObject indexObject) {
        luceneDao.update(indexObject);
    }

    @Override
    public void delete(IndexObject indexObject) {
        luceneDao.delete(indexObject);
    }

    @Override
    public void deleteAll() {
        luceneDao.deleteAll();
    }

    @Override
    public TableResultResponse page(Integer pageNumber, Integer pageSize, String keyword) {
        return luceneDao.page(pageNumber,pageSize,keyword);
    }
}
