
package own.stu.distributedTransaction.pay.service.user.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @功能说明:
 * @创建者: zh
 * @创建时间: 16/5/24  下午3:01
 * @公司名称:
 * @版本:
 */
public class AccountConfigUtil {

    private static final Log LOG = LogFactory.getLog(AccountConfigUtil.class);

    /**
     * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
     */
    private static Properties properties = new Properties();

    private AccountConfigUtil() {

    }

    // 通过类装载器装载进来
    static {
        try {
            // 从类路径下读取属性文件
            properties.load(AccountConfigUtil.class.getClassLoader()
                    .getResourceAsStream("account_config.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    /**
     * 函数功能说明 ：读取配置项 Administrator 2012-12-14 修改者名字 ： 修改日期 ： 修改内容 ：
     *
     * @参数：
     * @return void
     * @throws
     */
    public static String readConfig(String key) {
        return (String) properties.get(key);
    }
}
