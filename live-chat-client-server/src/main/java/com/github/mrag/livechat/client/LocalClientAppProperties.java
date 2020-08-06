package com.github.mrag.livechat.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myproperties")
public class LocalClientAppProperties {

    private String serverAddressPrefix;

    public String getServerAddressPrefix() {
        return serverAddressPrefix;
    }

    public LocalClientAppProperties setServerAddressPrefix(String serverAddressPrefix) {
        this.serverAddressPrefix = serverAddressPrefix;
        return this;
    }
}
