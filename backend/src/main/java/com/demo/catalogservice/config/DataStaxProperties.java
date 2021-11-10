package com.demo.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.File;

@ConfigurationProperties(prefix = "datastax.astra")
//@EnableCassandraRepositories
public class DataStaxProperties {
    private File secureConnectBundle;

    public File getSecureConnectBundle() {
        return secureConnectBundle;
    }

    public void setSecureConnectBundle(File secureConnectBundle) {
        this.secureConnectBundle = secureConnectBundle;
    }
}
