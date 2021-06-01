package edu.coursework.admissions.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    //@Bean
    public OpenAPI admissionsOpenApi(){

        return new OpenAPI().
                info(
                        new Info()
                                .title("Курсовий проект")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Masha")
                                        .url("my-site.cv.ua"))

                );
    }
}
