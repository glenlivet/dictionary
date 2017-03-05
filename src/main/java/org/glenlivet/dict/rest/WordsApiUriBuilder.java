package org.glenlivet.dict.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by glenlivet on 3/5/17.
 */
@Component
public class WordsApiUriBuilder {

    private String wordsApiHost;

    public WordsApiUriBuilder(@Value("${wordsapi.host}")String wordsApiHost) {
        this.wordsApiHost = wordsApiHost;
    }

    public String buildWordUrl(String word) {
        return UriComponentsBuilder
                .fromHttpUrl(this.wordsApiHost)
                .path("/words/{word}")
                .buildAndExpand(word)
                .encode()
                .toUriString();
    }
}
