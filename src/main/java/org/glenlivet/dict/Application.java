package org.glenlivet.dict;

import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.KatharsisConfigV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by glenlivet on 10/5/16.
 */
@Configuration
@RestController
@SpringBootApplication
@Import(KatharsisConfigV2.class)
public class Application {

    @Autowired
    private ResourceRegistry resourceRegistry;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
