package own.stu.distributedTransaction.common.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 基类 - 共有的增删查改，可以添加其他公共的方法
 */
public abstract class BaseService<T> implements IService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    public void saveData(T entity) {
        save(entity);
    }

    @Override
    public void updateData(T entity) {
        updateNotNull(entity);
    }

    @Override
    public T getDataById(Object key) {
        return selectByKey(key);
    }

    @Override
    public PageBean listPage(PageParam pageParam, T entity) {
        return null;
    }
}
