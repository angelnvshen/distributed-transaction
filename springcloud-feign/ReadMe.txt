springcloud - feign demo

注意：如果将feign定义接口，放置在其他模块中，其他web模块引用时，
需添加申明，如下
@EnableFeignClients(clients = UserService.class) // 申明 UserService 接口作为 Feign Client 调用

否则，报错找不到类的定义。

占位符问题：待解决
java.lang.IllegalStateException: Service id not legal hostname (${pay.web.trade.service.name})

@FeignClient(name = "${pay.web.trade.service.name}")
public interface RpTradePaymentQueryServiceApi {

    @RequestMapping("getRecordByBankOrderNo")
    RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo);
}