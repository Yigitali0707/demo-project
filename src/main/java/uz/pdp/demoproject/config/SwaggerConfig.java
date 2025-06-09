package uz.pdp.demoproject.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApis() {
        return GroupedOpenApi.builder()
                .group("User APIs")
                .pathsToMatch("/**/user/**")
                .build();
    }

    @Bean
    public GroupedOpenApi adminApis() {
        return GroupedOpenApi.builder()
                .group("Admin APIs")
                .pathsToMatch("/**/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi authApis() {
        return GroupedOpenApi.builder()
                .group("Authentication APIs")
                .pathsToMatch("/auth/**","/api/refreshToken")
                .build();
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                        .addParameters("X-Custom-Header", new Parameter()
                                .in(ParameterIn.HEADER.name())
                                .name("X-Custom-Header")
                                .required(true)
                                .schema(new io.swagger.v3.oas.models.media.StringSchema())
                                .description("Custom header for the request"))
                );
    }
}
