package com.chakrawaat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.chakrawaat.beans")
@ComponentScan(basePackages = "com.chakrawaat.beans.services")
public class ProjectConfig {
}
