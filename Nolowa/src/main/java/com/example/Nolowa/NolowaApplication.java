package com.example.Nolowa;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@EnableJpaAuditing
@SpringBootApplication
public class NolowaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NolowaApplication.class, args);
	}
}
