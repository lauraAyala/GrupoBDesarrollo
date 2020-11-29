package ar.edu.unq.desapp.grupoB.bakenddesappapl.security

import io.swagger.models.HttpMethod
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig {

    // antMatchers(HttpMethod.POST, "user/registerUser").
    @Throws(Exception::class)
    protected fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers("user/registerUser").permitAll()
                .antMatchers("user/login").permitAll()
                //.antMatchers(HttpMethod.POST, "/backoffice/login").permitAll()
                .antMatchers("project/openProjects").permitAll()
                .antMatchers("project/upcomingProjectsToClose").permitAll().anyRequest().authenticated().and()
                .httpBasic()
        http.csrf().disable().addFilterAfter(JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
        http.headers().frameOptions().disable()
    }
    //JWTAuthorizationFilter(),
}



