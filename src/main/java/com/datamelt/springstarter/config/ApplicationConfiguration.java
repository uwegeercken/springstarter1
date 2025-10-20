package com.datamelt.springstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "app")
public class ApplicationConfiguration
{
    private String name;
    private String version;
    private String date;
    private boolean loadDataOnStartup;

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

    public boolean isLoadDataOnStartup()
    {
        return loadDataOnStartup;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setLoadDataOnStartup(boolean loadDataOnStartup)
    {
        this.loadDataOnStartup = loadDataOnStartup;
    }
}
