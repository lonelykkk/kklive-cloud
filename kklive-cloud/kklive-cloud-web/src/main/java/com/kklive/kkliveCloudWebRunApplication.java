package com.kklive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 2025/2/9 9:55
 * @Version V1.0
 */

@SpringBootApplication(scanBasePackages = "com.kklive", exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
})
@EnableFeignClients
public class kkliveCloudWebRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(kkliveCloudWebRunApplication.class, args);
    }
}
