package com.l7r7.lab.app;

import com.l7r7.lab.module.a.ModuleAConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Option 1: Configuration class inside the module that does the component scan and is imported here
     */
    @Configuration
    @Import(ModuleAConfiguration.class)
    @ConditionalOnProperty("module.a.enabled")
    static class ModuleA {
    }

    /**
     * Option 2: component scan for the package of the module is done directly here
     */
    @Configuration
    @ConditionalOnProperty("module.b.enabled")
    @ComponentScan("com.l7r7.lab.module.b")
    static class ModuleB {
    }
}
