package org.glenlivet.dict.domain.repository;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.annotations.JsonApiFindAllWithIds;
import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by glenlivet on 2/26/17.
 */
@Component
@JsonApiResourceRepository(Definition.class)
public class DefinitionRepository {

    @JsonApiFindAllWithIds
    public Iterable<Definition> findAll(Iterable<Long> defIds, QuerySpec querySpec) {
        Definition def = new Definition();
        def.setId(1l);
        def.setDescription("abc desc.");
        def.setExamples(Arrays.asList("exp 1.", "exp 2.", "exp 3."));
        def.setPartOfSpeech("aaa");
        return Arrays.asList(def);
    }

}
