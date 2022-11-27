package com.wdyj.boilerplate.config.p6spy;

import com.p6spy.engine.spy.P6SpyOptions;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile(value = "local")
public class P6spyConfig {

    @PostConstruct
    public void setLogMessageFormat() {
        P6SpyOptions
                .getActiveInstance()
                .setLogMessageFormat(CustomP6spySqlFormat.class.getName());
    }
}
