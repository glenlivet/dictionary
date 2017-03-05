package org.glenlivet.dict.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.glenlivet.dict.domain.converter.WordConverter;
import org.glenlivet.dict.domain.exception.UnirestRuntimeException;
import org.glenlivet.dict.domain.json.WordJson;
import org.glenlivet.dict.domain.model.Word;
import org.glenlivet.dict.rest.WordsApiUriBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by glenlivet on 3/5/17.
 */
@Service
public class WordsApiServiceImpl implements WordsApiService {

    @Resource(name="wordsApiObjectMapper")
    private ObjectMapper objectMapper;

    @Autowired
    private WordsApiUriBuilder uriBuilder;

    @Override
    public Word word(String word) {

        try {
            HttpResponse<JsonNode> response = unirestGetJson(uriBuilder.buildWordUrl(word));
            String jsonStr = response.getBody().toString();
            JsonNode jsonNode = response.getBody();
            Object pronunciation = jsonNode.getObject().get("pronunciation");
            WordJson json = objectMapper.readValue(jsonStr, WordJson.class);
            Word retVal = WordConverter.convert(json);
            if (pronunciation instanceof String) {
                retVal.setPronunciation(pronunciation.toString());
            } else if (pronunciation instanceof JSONObject) {
                retVal.setPronunciation(((JSONObject)pronunciation).getString("all"));
            } else {
                new UnirestRuntimeException(new RuntimeException("Pronunciation is not parsable!"));
            }
            return retVal;
        } catch (UnirestException | IOException e) {
            throw new UnirestRuntimeException(e);
        }
    }

    private HttpResponse<JsonNode> unirestGetJson(String url) throws UnirestException {
        return Unirest.get(url)
                .header("X-Mashape-Key", mashapeKey)
                .header("Accept", "application/json")
                .asJson();
    }

    @Value("${wordsapi.mashape.key}")
    private String mashapeKey;

}
