package com.hulang.dingtalktest.demos.dingtalk;

import com.hulang.dingtalktest.demos.aiassistant.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: WeatherController
 * @date: 2025/3/31 15:58
 * @author: HuLang
 * @version: V1.0
 **/
@Slf4j
@RestController
@RequestMapping("/v1")
public class WeatherController {

    @GetMapping("/actions/example/weather/get")
    @ResponseBody
    public Map<String, Object> get(@RequestParam(value = "input", required = false) String input,
                                   @RequestParam(value = "inputAttribute", required = false) String attribute,
                                   @RequestParam(value = "openConversationId", required = false) String openConversationId,
                                   @RequestParam(value = "threadId", required = false) String threadId,
                                   @RequestParam(value = "runId", required = false) String runId,
                                   @RequestParam(value = "msgType", required = false) String msgType,
                                   @RequestParam(value = "corpId", required = false) String corpId,
                                   @RequestParam(value = "sender", required = false) String sender,
                                   @RequestParam(value = "conversationToken", required = false) String conversationToken,
                                   @RequestParam(value = "location", required = false) String location,
                                   @RequestParam(value = "date", required = false) String date) throws Exception {
        log.info("WeatherController get input:{}, attribute:{}, openConversationId:{}, threadId:{}, runId:{}, sender:{}, conversationToken:{}, location:{}, date:{}",
                input, attribute, openConversationId, threadId, runId, sender, conversationToken, location, date);

        Map<String, Object> result = new HashMap<>();
        //String location = "杭州";
        String dateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        result.put("location", location);
        result.put("dateStr", dateStr);
        result.put("text", "晴天");
        result.put("temperature", 22);
        result.put("humidity", 65);
        result.put("wind_direction", "东南风");
        return result;
    }

}
