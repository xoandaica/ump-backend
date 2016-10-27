package vn.ssdc.vnpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import vn.vnpt.ssdc.jdbc.factories.RepositoryFactory;

import javax.sql.DataSource;

/**
 * Created by vietnq on 10/25/16.
 */
@Configuration
public class UmpConfiguration {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public RepositoryFactory repositoryFactory(DataSource dataSource, RedisTemplate redisTemplate) {
        return new RepositoryFactory(dataSource, redisTemplate);
    }
}
