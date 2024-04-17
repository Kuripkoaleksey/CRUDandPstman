package com.example.CRUDPersonBDSpring;
import com.example.CRUDPersonBDSpring.Services.ProductServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration
public class CrudPersonBdSpringApplication {

	@Bean
	public ProductServices productServices(){
		ProductServices productServices = new ProductServices();
		return productServices;
	}
	public static void main(String[] args) {
		SpringApplication.run(CrudPersonBdSpringApplication.class, args);
	}

}



