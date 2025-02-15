package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.eazybytes.accounts.controller") })
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.model")*/
// use the above annotations to scan the packages for the application

// this is telling to enable OpenAPI for the application. springDoc
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(
				title = "Accounts MS API",
				description = "Accounts MS API",
				version = "1.0.0",
				contact = @Contact(
						name = "Mohit kumar Shaw",
						email = "mohitshaw2506@gmail.com",
						url = "https://github.com/mohitshaw01"
				)
		)
)
@EnableJpaAuditing(auditorAwareRef = "AuditAwareImpl")
// this is telling to enable JPA Auditing for the application used for createdBy and lastModifiedBy in the entities
@EnableConfigurationProperties(value = AccountsContactInfoDto.class)
// enable config to read values from application.yml file
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}

// http://localhost:8080/swagger-ui/index.html visit the website for swagger docs