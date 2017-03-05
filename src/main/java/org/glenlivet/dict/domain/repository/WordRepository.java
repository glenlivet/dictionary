package org.glenlivet.dict.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.annotations.JsonApiFindOne;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Word;
import org.glenlivet.dict.domain.service.WordsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by glenlivet on 2/26/17.
 */
@Component
@JsonApiResourceRepository(Word.class)
public class WordRepository {

    @Autowired
    private WordsApiService wordsApiService;

    @JsonApiFindOne
    public Word findOne(String id, QuerySpec querySpec) {
        return wordsApiService.word(id);
    }
}
