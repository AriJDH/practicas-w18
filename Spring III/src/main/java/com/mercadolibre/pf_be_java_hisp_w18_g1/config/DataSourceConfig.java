package com.mercadolibre.pf_be_java_hisp_w18_g1.config;

import com.fury.api.FuryUtils;
import com.fury.api.exceptions.FuryDecryptException;
import com.fury.api.exceptions.FuryNotFoundAPPException;
import com.fury.api.exceptions.FuryUpdateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@Profile("prod")// Es el nombre del scope que asociamos a la app en Fury y que vamos a levantar
public class DataSourceConfig {
    @Bean(name = "datasource")
    public DataSource dataSource() throws FuryDecryptException,
            FuryUpdateException, FuryNotFoundAPPException {
        String host = FuryUtils.getEnv("DB_MYSQL_DESAENV07_FRESCOS_FRESCOS_ENDPOINT"); // Snippets
        String password = FuryUtils.getEnv("DB_MYSQL_DESAENV07_FRESCOS_FIRESCOS_WPROD"); // Snippets
        String url = "jdbc:mysql://" + host + "/" + "first" +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false"; // Nombre del schema
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(url);
        builder.password(password);
        builder.username("frescos_WPROD"); // Username seg. snippets
        builder.driverClassName("com.mysql.cj.jdbc.Driver");
        return builder.build();
    }
}
