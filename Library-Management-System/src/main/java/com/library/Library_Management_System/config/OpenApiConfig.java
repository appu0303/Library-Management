package com.library.Library_Management_System.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI libraryOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Library Management System API")
                        .description("APIs for managing books, users, and roles in Library")
                        .version("v1.0"))
                .addTagsItem(new Tag().name("Book API").description("CRUD operations for books"))
                .addTagsItem(new Tag().name("User API").description("CRUD operations for users"))
                .addTagsItem(new Tag().name("Role API").description("CRUD operations for roles"));
    }
}
