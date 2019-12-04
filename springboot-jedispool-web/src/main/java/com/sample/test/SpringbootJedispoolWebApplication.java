package com.sample.test;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringbootJedispoolWebApplication {

    public static void main(String[] args) {
       SpringApplication.run(SpringbootJedispoolWebApplication.class, args);
    }

    /**
     *@描述 专门配置外部的yml文件
     *@参数  []
     *@返回值  org.springframework.context.support.PropertySourcesPlaceholderConfigurer
     *@创建人  huang.yj
     *@创建时间  2019/12/2
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();

        // 方式一：通过类路径，引入单个别的yml配置文件
        // yaml.setResources(new ClassPathResource("application-redis.yml"));

        // 方式二：通过类路径，引入多个别的yml配置文件
        yaml.setResources(
                new ClassPathResource[] {
                        /* 其他额外配置文件地址*/
                        new ClassPathResource("application-redis.yml")
                });

        // 方式三：通过文件系统路径，引入别的yml配置文件
        // yaml.setResources(new FileSystemResource("config.yml"));
        pspc.setProperties(yaml.getObject());

        return pspc;
    }
}
