package org.unidas.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

//

	@Configuration
	public class SwaggerConfig {

		@Bean
		public OpenAPI springBlogPessoalOpenAPI() {
			return new OpenAPI()
					.info(new Info()
						.title("Mais Unidas")
						.description("Projeto Mais Unidas - Generation Brasil")
						.version("v1.0.0")
					.license(new License()
						.name("org.unidas")
						.url("https://github.com/mig1998/Projeto_Integrador"))
					.contact(new Contact()
						.name("Miguel Araujo")
						.url("https://mig1998.github.io/")
						.email("miguelaras@hotmail.com")))
					.externalDocs(new ExternalDocumentation()
						.description("Github")
						.url("https://github.com/mig1998"));

			
		}
		
		@Bean
		public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

			return openApi -> {
				openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

					ApiResponses apiResponses = operation.getResponses();

					apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
					apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
					apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido!"));
					apiResponses.addApiResponse("400", createApiResponse("Erro na Requisi��o!"));
					apiResponses.addApiResponse("401", createApiResponse("Acesso N�o Autorizado!"));
					apiResponses.addApiResponse("404", createApiResponse("Objeto N�o Encontrado!"));
					apiResponses.addApiResponse("500", createApiResponse("Erro na Aplica��o!"));

				}));
			};
		}

		private ApiResponse createApiResponse(String message) {

			return new ApiResponse().description(message);

		}

		
		
	}