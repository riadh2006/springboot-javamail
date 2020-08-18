package com.example.springbootjavamail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@Configuration
public class EmailConfiguration {
	
	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
	    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	    templateResolver.setPrefix("/views/mail/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setTemplateMode("HTML");
	    templateResolver.setCharacterEncoding("UTF-8");
	    return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }
	
	@Bean
    public ResourceBundleMessageSource emailMessageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/mailMessages");
        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setBasenames("classpath:i18n/smsMessages", "classpath:i18n/emailMessages");
//        messageSource.setBasenames("classpath:i18n/smsMessages", "classpath:i18n/emailMessages");
        return messageSource;
    }


}
