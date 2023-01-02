package com.example.frescos.config;


import com.example.frescos.enums.ApplicationRol;
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
          .antMatchers(
            "/auth/agent",
                  "/auth/agent2",
                  "/api/v1/fresh-products/inboundorder",
                  "/api/v1/fresh-products/batch/list/due-date/*",
                  "/api/v1/fresh-products/{idProduct}/batch/list/*"
          ).hasAnyAuthority(ApplicationRol.AGENT.getCode())
          .antMatchers(
                  "/auth/buyer",
                  "/auth/buyer2",
                  "/api/v1/fresh-products/orders",
                  "/api/v1/fresh-products/orders/*",
                  "/api/v1/fresh-products/list"
          ).hasAnyAuthority(ApplicationRol.BUYER.getCode())
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
