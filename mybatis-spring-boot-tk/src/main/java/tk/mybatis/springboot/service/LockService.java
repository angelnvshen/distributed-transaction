package tk.mybatis.springboot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.springboot.mapper.TLockHistoryMapper;
import tk.mybatis.springboot.mapper.TLockMapper;
import tk.mybatis.springboot.model.TLock;
import tk.mybatis.springboot.model.TLockHistory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CHANEL on 2018/5/16.
 */
@Service
@Transactional
public class LockService {

    @Autowired
    private TLockMapper lockMapper;

    @Autowired
    private TLockHistoryMapper lockHistoryMapper;

    public int _updateByVersion(int key, int inc_value){
        TLock lock = lockMapper.selectByPrimaryKey(key);
        if(lock != null){

            saveHistory(lock);

            int now_value = Integer.valueOf(lock.getValue()) + inc_value;
            lock.setValue(now_value + "");
            return lockMapper.updateBy(lock);
        }
        return 0;
    }

    public void _selectForUpdate(int id, int inc_value){
        TLock lock = lockMapper.selectForUpdateByKey(id);
        doBis(lock, id, inc_value);
        //int i = 100/0; // rollback when error
    }
    public void _selectWithOutForUpdate(int key, int inc_value){
        TLock lock = lockMapper.selectByPrimaryKey(key);
        if(lock != null){
            doBis(lock, key, inc_value);
        }
    }

    private void doBis(TLock lock, int key, int inc_value ){

        saveHistory(lock);

        String current_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        int now_value = Integer.valueOf(lock.getValue()) + inc_value;
        lock.setValue(now_value + "");
        lockMapper.updateByPrimaryKeySelective(lock);
    }

    private void saveHistory(TLock lock){
        TLockHistory history = new TLockHistory();
        BeanUtils.copyProperties(lock, history, "id");
        history.setOldId(lock.getId());
        lockHistoryMapper.insert(history);
    }
}
