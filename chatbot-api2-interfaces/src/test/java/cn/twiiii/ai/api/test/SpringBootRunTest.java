package cn.twiiii.ai.api.test;

import cn.twiiii.ai.api.domain.ai.IOpenAI;
import cn.twiiii.ai.api.domain.zsxq.IZsxqApi;

import cn.twiiii.ai.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;
import cn.twiiii.ai.api.domain.zsxq.model.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

import java.util.List;

/**
 * @author 小傅哥，微信：fustack
 * @description
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

    private Logger logger = LoggerFactory.getLogger(SpringBootRunTest.class);

    @Value("${chatbot-api2.groupId}")
    private String groupId;
    @Value("${chatbot-api2.cookie}")
    private String cookie;
    @Value("${chatbot-api2.openAiKey}")
    private String openAiKey;

    @Resource
    private IZsxqApi zsxqApi;
    @Resource
    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getTalk().getText();
            logger.info("topicId：{} text：{}", topicId, text);

//            // 回答问题
            zsxqApi.answer(groupId, cookie, topicId, "2025/1/22 from IDEA");

//            zsxqApi.answer(groupId, cookie, topicId, openAI.doChatGPT(openAiKey, text));
        }
    }
    @Test
    public void testAns() throws IOException {
        String topicId="5121821455145814";
        zsxqApi.answer(groupId, cookie, topicId, "2025/1/22 from IDEA");
    }
    @Test
    public void test_openAi() throws IOException {
        String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
        logger.info("测试结果：{}", response);
    }

    @Test
    public void test_chatGPT() throws IOException {

//        HttpResponse<String> response = Unirest.post("https://api.chatanywhere.tech/v1/chat/completions")
//                .header("Authorization", "Bearer sk-1f58Sv45ZeqmDtrQzqDdMtFYtCMucKGDkpSnxH9oszqBMUTy")
//                .header("Content-Type", "application/json")
//                .body("{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [\n      {\n        \"role\": \"system\",\n        \"content\": \"You are a helpful assistant.\"\n      },\n      {\n        \"role\": \"user\",\n        \"content\": \"Hello!\"\n      }\n    ]\n  }")
//                .asString();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.chatanywhere.tech/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer sk-1f58Sv45ZeqmDtrQzqDdMtFYtCMucKGDkpSnxH9oszqBMUTy");

//        String paramJson = "{\"model\": \"gpt-3.5-turbo\", \"prompt\": \"帮我写一个java冒泡排序\", \"temperature\": 0, \"max_tokens\": 1024}";
//        String paramJson="{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [\n      {\n        \"role\": \"system\",\n        \"content\": \"You are a helpful assistant.\"\n      },\n      {\n        \"role\": \"user\",\n        \"content\": \"帮我写一个冒泡排序!\"\n      }\n    ]\n  }";
        String paramJson="{\n" +
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
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

}
