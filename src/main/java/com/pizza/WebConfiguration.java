/*package com.pizza;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){ 
            // Register resource handler for images
            registry.addResourceHandler("/img/**").addResourceLocations("/img/")
                    .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
      
    }
}*/