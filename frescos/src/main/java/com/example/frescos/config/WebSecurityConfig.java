package com.example.frescos.config;


import com.example.frescos.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Configuración para excluir end-points
     */
    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http.csrf()
          .disable()
          .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
          .authorizeRequests()
/*
          .antMatchers(
            "/api/v1/users/admin-1",
            "/api/v1/users/admin-2"
          ).hasAnyAuthority(RolE.ADMIN.getText())
          .antMatchers(
            "/api/v1/users/buyer-1",
            "/api/v1/users/buyer-2"
          ).hasAnyAuthority(RolE.BUYER.getText())
*/
          .anyRequest()
          .permitAll();
    }

    /**
     * Configuración para excluir paginas
     */
    @Override
    public void configure ( WebSecurity web ){
        web.ignoring()
          .antMatchers("/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/h2-console/**");
    }
}
