package com.wladek.pension.config;
import com.wladek.pension.domain.enumeration.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Keeun Baik
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "authService")
    private UserDetailsService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] permitAllUrls = new String[]{"/", "/users/signupform",
                "/users/loginform", "/users/login", "/users/loginfailure",
                "/users/logout", "/users/signup", "/test/**" , "/url-processor"};

        http.formLogin()
                .loginPage("/users/loginform")
                .loginProcessingUrl("/users/login")
                .failureUrl("/users/loginfailure")
                .defaultSuccessUrl("/url-processor")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/users/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
            .rememberMe()
                .key("pension")
                .tokenValiditySeconds(1296000)
                .userDetailsService(userDetailsService())
                .and()
            .authorizeRequests()
                .antMatchers(permitAllUrls).permitAll()
                .antMatchers("/admin/**").hasRole(UserRole.ADMIN.name())
                .antMatchers("/employee/**").hasRole(UserRole.EMPLOYEE.name())
                .anyRequest().hasRole(UserRole.ADMIN.name());


        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter> voters = new ArrayList<>();
        voters.add(new RoleHierarchyVoter(roleHierarchy()));
        voters.add(new AuthenticatedVoter());
        WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
        webExpressionVoter.setExpressionHandler(expressionHandler());
        voters.add(webExpressionVoter);
        return new AffirmativeBased(voters);
    }

    @Bean
    public SecurityExpressionHandler<FilterInvocation> expressionHandler() {
        DefaultWebSecurityExpressionHandler bean = new DefaultWebSecurityExpressionHandler();
        bean.setRoleHierarchy(roleHierarchy());
        return bean;
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl bean = new RoleHierarchyImpl();
        bean.setHierarchy("ROLE_ADMIN > ROLE_USER");
        return bean;
    }

}
