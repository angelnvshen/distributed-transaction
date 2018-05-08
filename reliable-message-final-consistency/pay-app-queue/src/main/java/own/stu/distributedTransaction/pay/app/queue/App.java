
package own.stu.distributedTransaction.pay.app.queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import own.stu.distributedTransaction.pay.app.queue.utils.SpringContextUtil;

/**
 * 
 * @描述: 通知APP.
 * @创建: 2019-5-14,下午3:11:19
 * @版本:
 *
 */
public class App { 

	private static final Log LOG = LogFactory.getLog(App.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/spring-context.xml" });
			// 初始化SpringContextUtil
			SpringContextUtil ctxUtil = new SpringContextUtil();
			ctxUtil.setApplicationContext(context);
			
			context.start();
			LOG.info("== context start");
			
		} catch (Exception e) {
			LOG.error("== application start error:", e);
			return;
		}
		
		synchronized (App.class) {
			while (true) {
				try {
					App.class.wait();
				} catch (InterruptedException e) {
					LOG.error("== synchronized error:", e);
				}
			}
		}
	}
}
