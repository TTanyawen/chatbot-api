package cn.twiiii.ai.api.domain.ai.service;


import cn.twiiii.ai.api.domain.ai.IOpenAI;
import cn.twiiii.ai.api.domain.ai.model.aggregates.AIAnswer;
import cn.twiiii.ai.api.domain.ai.model.vo.Choices;
import cn.twiiii.ai.api.domain.ai.model.vo.Message;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Service
public class OpenAI implements IOpenAI {

    private Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Override
    public String doChatGPT(String openAiKey, String question) throws IOException {

        logger.info("doChatGPT：{}", "doChatGPT");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 代理地址；open.aiproxy.xyz、open2.aiproxy.xyz


        HttpPost post = new HttpPost("https://api.chatanywhere.tech/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + openAiKey);

//        String paramJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + question + "\", \"temperature\": 0, \"max_tokens\": 1024}";
        String paramJson0="{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [\n" +
                "      {\n" +
                "        \"role\": \"system\",\n" +
                "        \"content\": \"You are a helpful assistant.\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"role\": \"user\",\n" +
                "        \"content\": \"Hello!帮我写一个冒泡排序\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

      String paramJson1 = "{\n" +
                "    \"model\": \"gpt-3.5-turbo\",\n" +
                "    \"messages\": [\n" +
                "      {\n" +
                "        \"role\": \"system\",\n" +
                "        \"content\": \"You are a helpful assistant.\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"role\": \"user\",\n" +
                "        \"content\": \"" + question + "\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }";
//        logger.info(paramJson0);

        ///////////////////////////避免字符串里的东西改变json/////////////////////
        // 使用 Jackson 构建 JSON 对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 构建 messages 数组
        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "You are a helpful assistant.");

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", question);

        // 将 messages 组装到参数中
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("model", "gpt-3.5-turbo");
        paramMap.put("messages", new Object[]{systemMessage, userMessage});

        // 转换为 JSON 字符串
        String paramJson = objectMapper.writeValueAsString(paramMap);
        ///////////////////////////避免字符串里的东西改变json/////////////////////


        logger.info(paramJson);
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices choice : choices) {
                answers.append(choice.getMessage().getContent());
            }
            return answers.toString();
        } else {
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }

}
