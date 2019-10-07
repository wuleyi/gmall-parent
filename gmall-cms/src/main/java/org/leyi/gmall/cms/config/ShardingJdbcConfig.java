package org.leyi.gmall.cms.config;

import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
public class ShardingJdbcConfig {

    @Bean
    public DataSource dataSource() throws IOException, SQLException {
        return MasterSlaveDataSourceFactory.createDataSource(ResourceUtils.getFile("classpath:sharding.yml"));
    }

}
