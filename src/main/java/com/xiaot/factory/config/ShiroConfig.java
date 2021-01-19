package com.xiaot.factory.config;

import com.xiaot.factory.config.realm.LoginRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Value("login")
    private String loginVerify;

    @Bean
    public LoginRealm loginRealm() {
        return new LoginRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        return new DefaultWebSecurityManager(loginRealm());
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        Map<String, String> filterMap = new LinkedHashMap<>();
        if (Boolean.parseBoolean(loginVerify)) {
            filterMap.put("/**", "authc");
        } else {
            filterMap.put("/**", "anon");
        }
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

}
