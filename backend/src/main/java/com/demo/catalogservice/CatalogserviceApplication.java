package com.demo.catalogservice;

import com.demo.catalogservice.config.DataStaxProperties;
import com.demo.catalogservice.model.Product;
import com.demo.catalogservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxProperties.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class CatalogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogserviceApplication.class, args);}

//	@PostConstruct
//	public void dummyStart(){
//		System.out.println("application started");
//		Product product = new Product("p-1","first product",11.0,"lksjfos","lsjf","lsf");
//		repository.save(product);
//	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxProperties dataStaxProperties){
		Path bundle = dataStaxProperties.getSecureConnectBundle().toPath();
		return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundle);
	}

}
