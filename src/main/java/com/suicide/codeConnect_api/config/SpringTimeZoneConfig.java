package com.suicide.codeConnect_api.config;

import jakarta.annotation.PostConstruct;

import java.util.TimeZone;

public class SpringTimeZoneConfig {

    @PostConstruct
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
