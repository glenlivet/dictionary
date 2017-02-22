package org.glenlivet.dict.domain.repository;

import com.google.common.collect.Lists;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by glenlivet on 10/5/16.
 */
@JsonApiResourceRepository(Word.class)
@Component
public class WordRepository {

    @JsonApiFindAll
    public Iterable<Word> findAll(QueryParams requestParams) {
        Definition def = new Definition();
        def.setId(1L);
        def.setDescription("some def");
        def.setPartOfSpeech("some part");
        def.setSynonyms(Lists.newArrayList("synonymous"));
        def.setExamples(Lists.newArrayList("some example."));

        Word word = new Word();
        word.setId(2L);
        word.setFrequency(new BigDecimal(4.12).setScale(2, RoundingMode.HALF_UP));
        word.setPronunciation("abc");
        word.setSpell("example");
        word.setDefinitions(Lists.newArrayList(def));

        return Lists.newArrayList(word);
    }
}
