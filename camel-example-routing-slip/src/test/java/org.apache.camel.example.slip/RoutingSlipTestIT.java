package org.apache.camel.example.slip;

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

public class RoutingSlipTestIT {
    private static final String URL_REQUEST = "http://localhost:8080/camel-example-routing-slip/camel/hello-slip-request";
    private static final String URL_RESPONSE = "http://localhost:8080/camel-example-routing-slip/camel/hello-slip-response";
    private static final String REQUEST_MESSAGE = "Hello";
    private static final String FIRST_EXPECTED_RESPONSE = "Hello A B C";
    private static final String SECOND_EXPECTED_RESPONSE = "Hello C A B";
    private static final String FIRST_SLIP = "direct:a,direct:b,direct:c";
    private static final String SECOND_SLIP = "direct:c,direct:a,direct:b";

    @Test
    public void testServletDefaultResponse() throws Exception {
        String firstResponseString = doHttpPostRequest(URL_REQUEST + "?helloslip=" + FIRST_SLIP, REQUEST_MESSAGE);
        String secondResponseString = doHttpPostRequest(URL_REQUEST + "?helloslip=" + SECOND_SLIP, REQUEST_MESSAGE);

        Assert.assertEquals(FIRST_EXPECTED_RESPONSE, firstResponseString);
        Assert.assertEquals(SECOND_EXPECTED_RESPONSE, secondResponseString);
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
