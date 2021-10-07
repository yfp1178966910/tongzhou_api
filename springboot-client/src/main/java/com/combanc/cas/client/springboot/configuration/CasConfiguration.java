package com.combanc.cas.client.springboot.configuration;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.Cas30ProxyReceivingTicketValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * cas 配置
 *
 * @author leijie
 */
@Configuration
@EnableConfigurationProperties({CasconfigProperties.class})
public class CasConfiguration {

    @Autowired
    private CasconfigProperties casconfigProperties;

    private static boolean casEnabled = true;


    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListener() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
        listener.setEnabled(casEnabled);
        listener.setListener(new SingleSignOutHttpSessionListener());
        listener.setOrder(1);
        return listener;
    }

    @Bean
    public FilterRegistrationBean singleSignOutFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new SingleSignOutFilter());
        filterRegistration.setEnabled(casEnabled);
        if (casconfigProperties.getSignOutFilters().size() > 0) {
            filterRegistration.setUrlPatterns(casconfigProperties.getSignOutFilters());
        } else {
            filterRegistration.addUrlPatterns("/*");
        }

        filterRegistration.addInitParameter("casServerUrlPrefix", casconfigProperties.getCasServerUrlPrefix().trim());
        filterRegistration.setOrder(2);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean authenticationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new AuthenticationFilter());
        filterRegistration.setEnabled(casEnabled);
        if (casconfigProperties.getAuthFilters().size() > 0) {
            filterRegistration.setUrlPatterns(casconfigProperties.getAuthFilters());
        } else {
            filterRegistration.addUrlPatterns("/*");
        }
        if (casconfigProperties.getIgnoreFilters() != null) {
            filterRegistration.addInitParameter("ignorePattern", casconfigProperties.getIgnoreFilters().trim());
        }
        filterRegistration.addInitParameter("casServerLoginUrl", casconfigProperties.getCasServerLoginUrl().trim());
        filterRegistration.addInitParameter("serverName", casconfigProperties.getServerName().trim());
        filterRegistration.addInitParameter("useSession", casconfigProperties.isUseSession() ? "true" : "false");
        filterRegistration.addInitParameter("redirectAfterValidation", casconfigProperties.isRedirectAfterValidation() ? "true" : "false");
        filterRegistration.setOrder(3);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean cas30ProxyReceivingTicketValidationFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new Cas30ProxyReceivingTicketValidationFilter());
        filterRegistration.setEnabled(casEnabled);
        if (casconfigProperties.getValidateFilters().size() > 0) {
            filterRegistration.setUrlPatterns(casconfigProperties.getValidateFilters());
        } else {
            filterRegistration.addUrlPatterns("/*");
        }

        filterRegistration.addInitParameter("casServerUrlPrefix", casconfigProperties.getCasServerUrlPrefix().trim());
        filterRegistration.addInitParameter("serverName", casconfigProperties.getServerName().trim());
        filterRegistration.addInitParameter("useSession", casconfigProperties.isUseSession() ? "true" : "false");
        filterRegistration.setOrder(4);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean httpServletRequestWrapperFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new HttpServletRequestWrapperFilter());
        filterRegistration.setEnabled(true);
        if (casconfigProperties.getRequestWrapperFilters().size() > 0) {
            filterRegistration.setUrlPatterns(casconfigProperties.getRequestWrapperFilters());
        } else {
            filterRegistration.addUrlPatterns("/*");
        }
        filterRegistration.setOrder(5);
        return filterRegistration;
    }

    @Bean
    public FilterRegistrationBean assertionThreadLocalFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new AssertionThreadLocalFilter());
        filterRegistration.setEnabled(true);
        if (casconfigProperties.getAssertionFilters().size() > 0) {
            filterRegistration.setUrlPatterns(casconfigProperties.getAssertionFilters());
        } else {
            filterRegistration.addUrlPatterns("/*");
        }
        filterRegistration.setOrder(6);
        return filterRegistration;
    }
}
