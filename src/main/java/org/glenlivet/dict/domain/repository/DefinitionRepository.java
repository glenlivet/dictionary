package org.glenlivet.dict.domain.repository;

import com.google.common.collect.Lists;
import io.katharsis.queryParams.QueryParams;
import io.katharsis.repository.annotations.JsonApiFindAll;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.springframework.stereotype.Component;

/**
 * Created by glenlivet on 10/5/16.
 */
@JsonApiResourceRepository(Definition.class)
@Component
public class DefinitionRepository {

    @JsonApiFindAll
    public Iterable<Definition> findAll(QueryParams requestParams) {
        Definition def = new Definition();
        def.setId(1L);
        def.setDescription("some def");
        def.setPartOfSpeech("some part");
        def.setSynonyms(Lists.newArrayList("synonymous"));
        def.setExamples(Lists.newArrayList("some example."));
        return Lists.newArrayList(def);
    }
}
