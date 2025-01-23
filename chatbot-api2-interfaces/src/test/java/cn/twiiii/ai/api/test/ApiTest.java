package cn.twiiii.ai.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 单元测试
 */
public class ApiTest {

    @Test
    public void testquestion(){

    }

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=EE51E4E5-8268-99CA-2586-DFD02BE19EAE_C1E6AE20A9F1A01F; zsxqsessionid=8638caf273526b22faac4e5a4ddafd63; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184121824181442%22%2C%22first_id%22%3A%221948820ee3366b-0591a9e4e3d624-26011b51-870100-1948820ee341a3b%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk0ODgyMGVlMzM2NmItMDU5MWE5ZTRlM2Q2MjQtMjYwMTFiNTEtODcwMTAwLTE5NDg4MjBlZTM0MWEzYiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NDEyMTgyNDE4MTQ0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184121824181442%22%7D%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/5121821455145814/comments");
        post.addHeader("cookie","zsxq_access_token=EE51E4E5-8268-99CA-2586-DFD02BE19EAE_C1E6AE20A9F1A01F; zsxqsessionid=8638caf273526b22faac4e5a4ddafd63; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22184121824181442%22%2C%22first_id%22%3A%221948820ee3366b-0591a9e4e3d624-26011b51-870100-1948820ee341a3b%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk0ODgyMGVlMzM2NmItMDU5MWE5ZTRlM2Q2MjQtMjYwMTFiNTEtODcwMTAwLTE5NDg4MjBlZTM0MWEzYiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjE4NDEyMTgyNDE4MTQ0MiJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22184121824181442%22%7D%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"answer from IDEA\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

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
