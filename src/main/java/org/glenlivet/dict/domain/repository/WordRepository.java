package org.glenlivet.dict.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by glenlivet on 2/26/17.
 */
@Component
@JsonApiResourceRepository(Word.class)
public class WordRepository {

    @JsonApiFindOne
    public Word findOne(String id, QuerySpec querySpec) {
        Word word = new Word();
        word.setPronunciation("ɪɡ'zæmpəl");
        word.setFrequency(new BigDecimal(3.5));
        word.setId(id);

        Definition def = new Definition();
        def.setId(1l);
        def.setDescription("abc desc.");
        def.setExamples(Arrays.asList("exp 1.", "exp 2.", "exp 3."));
        def.setPartOfSpeech("aaa");
        word.setDefinitions(Arrays.asList(def));
        return word;
    }
}
