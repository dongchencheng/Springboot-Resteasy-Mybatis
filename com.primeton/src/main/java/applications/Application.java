package applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**   
 * @Description: 启动类
 * @author dongcc (mailto:dongcc@primeton.com)
 * @date 2016年7月28日 下午9:19:50 
 * @version V1.0
 */

@ImportResource(value = "applicationContext-mybatis.xml")
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("controller,filter")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
