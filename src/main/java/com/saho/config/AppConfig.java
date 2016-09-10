package com.saho.config;

        import com.saho.converter.BookIdtoBookConverter;
        import com.saho.converter.RoleToAuthTypeConverter;
        import com.saho.converter.UserIdToUserConverter;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.MessageSource;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.support.ResourceBundleMessageSource;
        import org.springframework.format.FormatterRegistry;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
        import org.springframework.web.servlet.view.InternalResourceViewResolver;
        import org.springframework.web.servlet.view.JstlView;

/**
 * Created by sahin.dagdelen on 1/21/2016.
 * //@Import({SecurityConfig.class})
 */


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.saho.*"})
public class AppConfig extends WebMvcConfigurerAdapter {


    @Autowired
    RoleToAuthTypeConverter  roleToAuthTypeConverter;


    @Autowired
    BookIdtoBookConverter bookIdtoBookConverter;

    @Autowired
    UserIdToUserConverter userIdToUserConverter;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        registry.viewResolver(internalResourceViewResolver);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(bookIdtoBookConverter);
        registry.addConverter(roleToAuthTypeConverter);
          registry.addConverter(userIdToUserConverter);
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


}
