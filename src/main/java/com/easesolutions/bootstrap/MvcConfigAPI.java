package com.easesolutions.bootstrap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration for controller classes that handles API calls.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.easesolutions.controller.api"})
public class MvcConfigAPI {

}