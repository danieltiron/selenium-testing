package org.framework.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.IOException;

public class ApiRequests {
    public static String url = "";

    private static HttpResponse getResponse(){
        HttpResponse response = null;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        try {
            response = client.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static int getResponseCode() {
        return getResponse().getStatusLine().getStatusCode();
    }

    public static String getResponsePayload(){
        HttpResponse response = getResponse();

        return new JSONObject(response.getEntity()).toString();
    }

    public static void closeConnection(){
        HttpResponse response = getResponse();

        if (response.getEntity() != null ) {
            try {
                response.getEntity().consumeContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
