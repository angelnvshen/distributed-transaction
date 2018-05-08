package own.stu.distributedTransaction.pay.web.shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2016/12/23.
 */
@Component
public class ReadPropertiesUtil {

    @Autowired
    private Environment env;

    public void setEnv(Environment env) {
        this.env = env;
    }

    public String isBlank(String key) {
        String _tmp = env.getProperty(key) + env.getProperty("isBlank");
        String str2 = null;
        try {
            str2 = new String(_tmp.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public String isLegal(String key) {
        String _tmp = env.getProperty(key) + env.getProperty("not_legal");
        String str2 = null;
        try {
            str2 = new String(_tmp.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }
  
    public String getProperty(String key) {
        String _tmp = env.getProperty(key);
        String str2 = null;
        try {
            str2 = new String(_tmp.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }
}
