package org.apache.camel.example.servlettomcat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

public class ServletTomcatTestIT {
    private static final String URL_WITH_PARAM = "http://localhost:8080/camel-example-servlet-tomcat/camel/hello?name=Robert";
    private static final String URL_DEFAULT = "http://localhost:8080/camel-example-servlet-tomcat/camel/hello";
    private static final String EXPECTED_RESPONSE_WITH_PARAM = "Hello Robert how are you?";
    private static final String EXPECTED_RESPONSE_DEFAULT = "Add a name parameter to uri, eg ?name=foo";

    @Test
    public void testServletDefaultResponse() throws Exception {
        String defaultResponse = doHttpRequest(URL_DEFAULT);
        Assert.assertEquals(EXPECTED_RESPONSE_DEFAULT, defaultResponse);
    }

    @Test
    public void testServletParamResponse() throws Exception {
        String paramResponse = doHttpRequest(URL_WITH_PARAM);
        Assert.assertEquals(EXPECTED_RESPONSE_WITH_PARAM, paramResponse);
    }

    private String doHttpRequest(String requestString) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(requestString);
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity);
    }
}
