package com.datamelt.springstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "app")
public class ApplicationConfiguration
{
    private final String name;
    private final String version;
    private final String date;

    public ApplicationConfiguration(String name, String version, String date)
    {
        this.name = name;
        this.version = version;
        this.date = date;
    }

    public String getName()
    {
        return name;
    }

    public String getVersion()
    {
        return version;
    }

    public String getDate()
    {
        return date;
    }
}
