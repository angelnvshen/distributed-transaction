
package own.stu.distributedTransaction.pay.service.trade.utils.alipay.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @功能说明:
 * @创建者:
 * @创建时间: 16/6/14  下午3:43
 * @公司名称:
 * @版本:
 */
public class AliPayUtil {

    public static Map<String , String> parseNotifyMsg(Map<String, String[]> requestParams){

        Map<String,String> params = new HashMap<String,String>();

        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        return params;
    }

}
