package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.TLockHistoryMapper;
import tk.mybatis.springboot.mapper.TLockMapper;

@Service
public class PropagationService {

    @Autowired
    private TLockMapper lockMapper;

    @Autowired
    private TLockHistoryMapper historyMapper;

    public String test
}
