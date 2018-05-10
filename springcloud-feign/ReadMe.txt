springcloud - feign demo

ע�⣺�����feign����ӿڣ�����������ģ���У�����webģ������ʱ��
���������������
@EnableFeignClients(clients = UserService.class) // ���� UserService �ӿ���Ϊ Feign Client ����

���򣬱����Ҳ�����Ķ��塣

ռλ�����⣺�����
java.lang.IllegalStateException: Service id not legal hostname (${pay.web.trade.service.name})

@FeignClient(name = "${pay.web.trade.service.name}")
public interface RpTradePaymentQueryServiceApi {

    @RequestMapping("getRecordByBankOrderNo")
    RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo);
}