package org.glenlivet.dict.domain.repository;

import io.katharsis.repository.annotations.JsonApiResourceRepository;
import org.glenlivet.dict.domain.model.Definition;
import org.springframework.stereotype.Component;

/**
 * Created by glenlivet on 2/26/17.
 */
@Component
@JsonApiResourceRepository(Definition.class)
public class DefinitionRepository {

}
