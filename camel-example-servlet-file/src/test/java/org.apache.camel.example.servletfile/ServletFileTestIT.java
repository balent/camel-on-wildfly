package org.apache.camel.example.servletfile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;


public class ServletFileTestIT {
    private static final String URL_REQUEST = "http://localhost:8080/camel-example-servlet-file/camel/hello-file-request";
    private static final String URL_RESPONSE = "http://localhost:8080/camel-example-servlet-file/camel/hello-file-response";
    private static final String EXPECTED_RESPONSE = "Hello World!";

    @Test
    public void testServletDefaultResponse() throws Exception {
        doHttpRequest(URL_REQUEST);
        String responseString = doHttpRequest(URL_RESPONSE);
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
