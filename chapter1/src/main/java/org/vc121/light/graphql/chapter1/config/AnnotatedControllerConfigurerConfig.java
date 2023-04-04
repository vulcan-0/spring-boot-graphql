package org.vc121.light.graphql.chapter1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.method.annotation.support.AnnotatedControllerConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author lxc
 * @date 2023/04/04
 */
@Configuration
public class AnnotatedControllerConfigurerConfig {

    @Bean
    public AnnotatedControllerConfigurer annotatedControllerConfigurer() {
        AnnotatedControllerConfigurer controllerConfigurer = new AnnotatedControllerConfigurer();
        controllerConfigurer.setExecutor(createBatchMappingExecutor());
        return controllerConfigurer;
    }

    private ThreadPoolTaskExecutor createBatchMappingExecutor() {
        var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setPrestartAllCoreThreads(true);
        executor.initialize();
        return executor;
    }

}
