package com.hulang.dingtalktest.demos.aiassistant;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenResponse;
import com.aliyun.tea.TeaException;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: SendMessage
 * @date: 2025/4/1 13:47
 * @author: HuLang
 * @version: V1.0
 **/
@Slf4j
public class SendMessage {
    /**
     * 使用 Token 初始化账号Client
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dingtalkai_interaction_1_0.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkai_interaction_1_0.Client(config);
    }

    public static com.aliyun.dingtalkoauth2_1_0.Client createTokenClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkoauth2_1_0.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        com.aliyun.dingtalkai_interaction_1_0.Client client = SendMessage.createClient();
        com.aliyun.dingtalkai_interaction_1_0.models.ReplyHeaders replyHeaders = new com.aliyun.dingtalkai_interaction_1_0.models.ReplyHeaders();
        String token = SendMessage.getToken();
        log.info("token is " + token);
        replyHeaders.xAcsDingtalkAccessToken = token;
        com.aliyun.dingtalkai_interaction_1_0.models.ReplyRequest replyRequest = new com.aliyun.dingtalkai_interaction_1_0.models.ReplyRequest()
                .setConversationToken("ct_01jqr74603eajb29qwt2epxvvb")
                .setContentType("ai_card")
                .setContent("{\"templateId\": \"c9258ba4-50ee-4988-9d70-a5c2d2e78935.schema\",\"cardData\": {\"title\":\"我是标题\",\"desc\":\"我是描述。\"}}");
        try {
            client.replyWithOptions(replyRequest, replyHeaders, new com.aliyun.teautil.models.RuntimeOptions());
        } catch (Exception e) {
            log.error("getAccessToken error", e);
        }
    }

    public static String getToken() throws Exception {
        com.aliyun.dingtalkoauth2_1_0.Client client = SendMessage.createTokenClient();
        com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest getAccessTokenRequest = new com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest()
                .setAppKey("dingdhxefajlldksi7tp")
                .setAppSecret("RUo7LYA9FVfzk3NINLVaYimQB50ziAei6UHvK-EUqU6txuG4EWt3a_uO1DVYydfU");
        try {
            GetAccessTokenResponse response = client.getAccessToken(getAccessTokenRequest);
            log.info("getAccessTokenResponse is " + JSONObject.toJSONString(response));
            return response.body.accessToken;
        } catch (Exception e) {
            log.error("getAccessToken error", e);
        }
        return null;
    }
}
