package com.chakrawaat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.chakrawaat.beans", "com.chakrawaat.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
}
