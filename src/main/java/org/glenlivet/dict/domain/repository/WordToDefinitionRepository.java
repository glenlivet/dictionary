package org.glenlivet.dict.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.annotations.JsonApiFindManyTargets;
import io.katharsis.repository.annotations.JsonApiRelationshipRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by glenlivet on 2/26/17.
 */
@JsonApiRelationshipRepository(source=Word.class, target=Definition.class)
@Component
public class WordToDefinitionRepository {

    @JsonApiFindManyTargets
    public Iterable<Definition> findManyTargets(String word, String fieldName, QuerySpec requestParams) {
        Definition def = new Definition();
        def.setId(1l);
        def.setDescription("abc desc.");
        def.setExamples(Arrays.asList("exp 1.", "exp 2.", "exp 3."));
        def.setPartOfSpeech("aaa");
        return Arrays.asList(def);
    }
}
