package br.com.guilherme.lemes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("br.com.guilherme.lemes.core.*")
@Import({ SystemDbConfig.class })
public class CoreConfig {

}