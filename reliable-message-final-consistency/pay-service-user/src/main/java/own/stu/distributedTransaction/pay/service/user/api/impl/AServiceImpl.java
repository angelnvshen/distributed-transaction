package own.stu.distributedTransaction.pay.service.user.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.pay.service.user.api.AService;
import own.stu.distributedTransaction.pay.service.user.api.BService;

@Primary
@Service
public class AServiceImpl implements AService {

    @Autowired
    BService bService;

    @Override
    public String print() {
        bService.print();
        return "AServiceImpl";
    }
}
