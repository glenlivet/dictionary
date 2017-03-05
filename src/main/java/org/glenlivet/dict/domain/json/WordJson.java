package org.glenlivet.dict.domain.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by glenlivet on 3/5/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordJson {

    @JsonProperty
    private String word;

    @JsonProperty
    private BigDecimal frequency;

    @JsonIgnore
    private Map<String, String> pronunciationMap = new HashMap<>();

    @JsonIgnore
    private String pronunciation;

    @JsonProperty
    private List<DefinitionJson> results = new ArrayList<>();

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public BigDecimal getFrequency() {
        return frequency;
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    public List<DefinitionJson> getResults() {
        return results;
    }

    public void setResults(List<DefinitionJson> results) {
        this.results = results;
    }

    public Map<String, String> getPronunciationMap() {
        return pronunciationMap;
    }

    public void setPronunciationMap(Map<String, String> pronunciationMap) {
        this.pronunciationMap = pronunciationMap;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
}
