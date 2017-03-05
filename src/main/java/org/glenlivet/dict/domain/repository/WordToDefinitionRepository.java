package org.glenlivet.dict.domain.repository;

import io.katharsis.repository.annotations.JsonApiRelationshipRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.glenlivet.dict.domain.model.Word;
import org.springframework.stereotype.Component;

/**
 * Created by glenlivet on 2/26/17.
 */
@JsonApiRelationshipRepository(source=Word.class, target=Definition.class)
@Component
public class WordToDefinitionRepository {

}
