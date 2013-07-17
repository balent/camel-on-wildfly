package org.apache.camel.example.timer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TimerTestIT {
    private static final String URL_RESPONSE = "http://localhost:8080/camel-example-timer-no-spring/camel/hello-timer-responseno-spring";
    private static final String EXPECTED_RESPONSE = "Hello World!";

    @Test(timeout = 60000)
    public void testServletDefaultResponse() throws Exception {
        // First two requests to catch with timer
        doHttpRequest(URL_RESPONSE);
        doHttpRequest(URL_RESPONSE);

        for (int i = 0; i < 2; i++) {
            System.out.println("Waiting 5 seconds for timer...");
            long startTime = new Date().getTime();
            String responseString = doHttpRequest(URL_RESPONSE);
            long endTime = new Date().getTime();
            long diff = endTime - startTime;
            Assert.assertTrue("Time should be between 4 and 6 seconds", diff > 4000 && diff < 6000);
            Assert.assertEquals(EXPECTED_RESPONSE, responseString);
        }
    }

    private String doHttpRequest(String requestString) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(requestString);
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }
}
