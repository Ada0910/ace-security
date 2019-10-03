package com.ada.common.biz;

import com.ada.common.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Ada
 * @ClassName :BaseBiz
 * @date 2019/10/3 16:27
 * @Description:
 */
public abstract class BaseBiz<M extends Mapper<T>, T> {

    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }

    public void insert(T entity) {
        EntityUtil.setCreateAndUpdateInfo(entity);
        mapper.insert(entity);
    }

    public void insertSelective(T entity) {
        EntityUtil.setCreateAndUpdateInfo(entity);
        mapper.insertSelective(entity);
    }

}
