package tk.mybatis.springboot.mapper;

import tk.mybatis.springboot.model.TLock;
import tk.mybatis.springboot.util.MyMapper;

public interface TLockMapper extends MyMapper<TLock> {

    TLock selectForUpdateByKey(int key);
}