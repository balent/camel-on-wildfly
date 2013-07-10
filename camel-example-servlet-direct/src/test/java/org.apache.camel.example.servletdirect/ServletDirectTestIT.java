package org.apache.camel.example.servletdirect;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;


public class ServletDirectTestIT {
    private static final String URL_REQUEST = "http://localhost:8080/camel-example-servlet-direct/camel/hello-direct-request";
    private static final String URL_RESPONSE = "http://localhost:8080/camel-example-servlet-direct/camel/hello-direct-response";
    private static final String EXPECTED_RESPONSE = "Hello World!";

    @Test
    public void testServletDefaultResponse() throws Exception {
        System.out.println("First request: " + doHttpRequest(URL_REQUEST));
        String responseString = doHttpRequest(URL_RESPONSE);
        System.out.println("Second request: " + responseString);
        Assert.assertEquals(EXPECTED_RESPONSE, responseString);
    }

    private String doHttpRequest(String requestString) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(requestString);
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }
}
