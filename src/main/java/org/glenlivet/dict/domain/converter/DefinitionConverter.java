package org.glenlivet.dict.domain.converter;

import com.google.common.io.BaseEncoding;
import org.glenlivet.dict.domain.json.DefinitionJson;
import org.glenlivet.dict.domain.model.Definition;

/**
 * Created by glenlivet on 3/5/17.
 */
public class DefinitionConverter {

    public static Definition convert(DefinitionJson json) {
        Definition def = new Definition();
        String baseEncodedId = BaseEncoding.base32().encode(json.getDefinition().getBytes());
        def.setId(baseEncodedId);
        def.setDescription(json.getDefinition());
        def.setPartOfSpeech(json.getPartOfSpeech());
        def.setExamples(json.getExamples());
        def.setAntonyms(json.getAntonyms());
        def.setDerivation(json.getDerivation());
        def.setSynonyms(json.getSynonyms());
        return def;
    }
}
