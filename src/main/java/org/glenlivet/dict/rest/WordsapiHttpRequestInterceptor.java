package org.glenlivet.dict.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by glenlivet on 3/5/17.
 */
@Component
public class WordsApiHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private String mashapekey;

    @Autowired
    public WordsApiHttpRequestInterceptor(
            @Value("${wordsapi.mashape.key}")
            String mashapeKey) {
        this.mashapekey = mashapeKey;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {

        HttpHeaders httpHeaders = httpRequest.getHeaders();
        httpHeaders.add("X-Mashape-Key", mashapekey);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        return execution.execute(httpRequest, bytes);
    }
}
