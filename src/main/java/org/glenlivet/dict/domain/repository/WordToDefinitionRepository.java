package org.glenlivet.dict.domain.repository;

import com.google.common.collect.Lists;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindManyTargets;
import io.katharsis.repository.annotations.JsonApiFindOneTarget;
import io.katharsis.repository.annotations.JsonApiRelationshipRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;
import org.springframework.stereotype.Component;

/**
 * Created by glenlivet on 10/5/16.
 */
@JsonApiRelationshipRepository(source = Word.class, target = Definition.class)
@Component
public class WordToDefinitionRepository {

    @JsonApiFindOneTarget
    public Definition findOneTarget(Long projectId, String fieldName, QueryParams requestParams) {
        Definition def = new Definition();
        def.setId(1L);
        def.setDescription("some def");
        def.setPartOfSpeech("some part");
        def.setSynonyms(Lists.newArrayList("synonymous"));
        def.setExamples(Lists.newArrayList("some example."));
        return def;
    }

    @JsonApiFindManyTargets
    public Iterable<Definition> findManyTargets(Long projectId, String fieldName, QueryParams requestParams) {
        Definition def = new Definition();
        def.setId(1L);
        def.setDescription("some def");
        def.setPartOfSpeech("some part");
        def.setSynonyms(Lists.newArrayList("synonymous"));
        def.setExamples(Lists.newArrayList("some example."));
        return Lists.newArrayList(def);
    }
}
