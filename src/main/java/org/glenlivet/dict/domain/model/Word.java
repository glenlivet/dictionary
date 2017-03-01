package org.glenlivet.dict.domain.model;

import io.katharsis.resource.annotations.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by glenlivet on 10/5/16.
 */
@JsonApiResource(type = "words")
public class Word {

    @JsonApiId
    private String id;

    private String pronunciation;

    private BigDecimal frequency;

    @JsonApiToMany
    @JsonApiIncludeByDefault
    private List<Definition> definitions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public BigDecimal getFrequency() {
        return frequency;
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }
}
