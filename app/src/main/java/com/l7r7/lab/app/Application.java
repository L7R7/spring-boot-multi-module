package com.l7r7.lab.app;

import com.l7r7.lab.module.a.ModuleAConfiguration;
import com.l7r7.lab.module.b.ModuleBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    @Import(ModuleAConfiguration.class)
    @ConditionalOnProperty("module.a.enabled")
    static class ModuleA {
    }

    @Configuration
    @ConditionalOnProperty("module.b.enabled")
    @Import(ModuleBConfiguration.class)
    static class ModuleB {
    }
}
