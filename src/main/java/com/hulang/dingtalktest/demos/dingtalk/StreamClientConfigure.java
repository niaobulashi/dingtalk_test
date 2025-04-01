package com.hulang.dingtalktest.demos.dingtalk;

import com.dingtalk.open.app.api.OpenDingTalkClient;
import com.dingtalk.open.app.api.OpenDingTalkStreamClientBuilder;
import com.dingtalk.open.app.api.security.AuthClientCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: StreamClientConfigure
 * @date: 2025/3/31 10:27
 * @author: HuLang
 * @version: V1.0
 **/
@Configuration
public class StreamClientConfigure {

    @Value("${dingtalk.app.client-id}")
    private String clientId;

    @Value("${dingtalk.app.client-secret}")
    private String clientSecret;

    @Bean(initMethod = "start")
    public OpenDingTalkClient configure(StreamActionsDispatcher dispatcher) {
        return OpenDingTalkStreamClientBuilder.custom()
                .credential(new AuthClientCredential(clientId, clientSecret))
                .registerCallbackListener("/v1.0/graph/api/invoke", dispatcher)
                .build();
    }

    @Bean(initMethod = "start")
    public OpenDingTalkClient configure() {
        return OpenDingTalkStreamClientBuilder.custom()
                .credential(new AuthClientCredential(clientId, clientSecret))
                .forwardGraphRequestToHTTP(8085)
                .build();
    }
}
