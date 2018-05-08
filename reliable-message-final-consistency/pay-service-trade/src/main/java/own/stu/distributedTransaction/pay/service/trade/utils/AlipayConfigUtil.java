
package own.stu.distributedTransaction.pay.service.trade.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @类功能说明： 支付宝属性文件加载工具.
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @创建时间：2019年6月14日,上午9:55:03.
 *
 */
public class AlipayConfigUtil {

	private static final Log LOG = LogFactory.getLog(AlipayConfigUtil.class);

	/**
	 * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
	 */
	private static Properties properties = new Properties();

	private AlipayConfigUtil() {

	}

	// 通过类装载器装载进来
	static {
		try {
			// 从类路径下读取属性文件
			properties.load(AlipayConfigUtil.class.getClassLoader().getResourceAsStream("alipay_config.properties"));
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
