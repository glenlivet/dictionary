package org.glenlivet.dict.domain.converter;

import org.glenlivet.dict.domain.json.WordJson;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by glenlivet on 3/5/17.
 */
public class WordConverter {

    public static Word convert(WordJson json) {
        Word word = new Word();
        word.setId(json.getWord());
        word.setFrequency(json.getFrequency().setScale(0, BigDecimal.ROUND_HALF_UP));
        List<Definition> definitionList = json.getResults().stream()
                .map(DefinitionConverter::convert)
                .collect(Collectors.toList());
        word.setDefinitions(definitionList);
        return word;
    }
}
