package com.advancedjava.springwebmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.advancedjava.springwebmvc")
@Import({WebConfiguration.class, JpaConfiguration.class, SecurityConfiguration.class})
public class AppConfiguration {
}
