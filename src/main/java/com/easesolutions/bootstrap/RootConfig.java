package com.easesolutions.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Bootstrap for service layer.
 */
@Configuration
@PropertySource({ "classpath:spring.properties" })
@ComponentScan(basePackages = { "com.easesolutions.service", "com.easesolutions.dao", "com.easesolutions.util" })
public class RootConfig {

}