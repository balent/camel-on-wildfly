package org.apache.camel.example.multicast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

public class MulticastTestIT {
    private static final String URL_REQUEST = "http://localhost:8080/camel-example-multicast-no-spring/camel/hello-multicast-no-spring-request";
    private static final String URL_RESPONSE = "http://localhost:8080/camel-example-multicast-no-spring/camel/hello-multicast-no-spring-response";
    private static final String REQUEST_MESSAGE = "Hello";
    private static final String EXPECTED_RESPONSE = "Hello";

    @Test
    public void testServletDefaultResponse() throws Exception {
        doHttpPostRequest(URL_REQUEST, REQUEST_MESSAGE);
        for (int i = 1; i < 4; i++) {
            String responseString = doHttpRequest(URL_RESPONSE + i);
            Assert.assertEquals(EXPECTED_RESPONSE + " " + i, responseString);
        }
    }

    private String doHttpRequest(String requestUrl) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(requestUrl);
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }

    private String doHttpPostRequest(String requestUrl, String requestBody) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(requestUrl);
        StringEntity entity = new StringEntity(requestBody);

        httpPost.setEntity(entity);
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        return EntityUtils.toString(responseEntity);
    }
}
