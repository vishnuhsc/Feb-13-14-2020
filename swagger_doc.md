## Generate API docs using Swagger

* Add the following dependencies to pom.xml

``` xml
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```

* Create a class __AppConfiguration__ with the following code

``` java

@Configuration
@EnableSwagger2
public class AppConfiguration {

	@Bean
	public Docket swaggerBankApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hss"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Bank of Hughes").description("API documentation v1.0").build());
	}
}

``` 

* Run the app and go to http://localhost:8080/swagger-ui.html