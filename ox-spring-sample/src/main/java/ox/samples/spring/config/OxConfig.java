package ox.samples.spring.config;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ox.engine.Ox;
import ox.engine.exception.InvalidMongoConfiguration;

@Configuration
public class OxConfig {

    @Autowired
    @Bean
    public Ox ox(Mongo mongo) throws InvalidMongoConfiguration {
        Ox ox = Ox.setUp(mongo, "ox.samples.spring.ox.migrations", "ox-sample");
        ox.up();
        return ox;
    }

}
