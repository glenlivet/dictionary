package org.glenlivet.dict.domain.service;

import org.glenlivet.dict.domain.model.Word;

/**
 * Created by glenlivet on 2/26/17.
 */
public interface WordService {

    Word get(String spell);
}
