package own.stu.distributedTransaction.pay.service.user.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.pay.service.user.api.AService;
import own.stu.distributedTransaction.pay.service.user.api.BService;

@Primary
@Service
public class BServiceImpl implements BService {

    @Autowired
    AService aService;

    @Override
    public String print() {
        aService.print();
        return "BServiceImpl";
    }
}
