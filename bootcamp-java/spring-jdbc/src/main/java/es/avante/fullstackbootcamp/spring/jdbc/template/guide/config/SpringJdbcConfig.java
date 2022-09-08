package es.avante.fullstackbootcamp.spring.jdbc.template.guide.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("es.avante.fullstackbootcamp.spring.jdbc.template.guide")
public class SpringJdbcConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
          .setType(EmbeddedDatabaseType.H2)
          .addScript("classpath:es/avante/fullstackbootcamp/spring/jdbc/template/guide/schema.sql")
          .addScript("classpath:es/avante/fullstackbootcamp/spring/jdbc/template/guide/test-data.sql")
          .build();
    }
}