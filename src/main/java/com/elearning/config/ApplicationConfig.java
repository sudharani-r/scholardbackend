package com.elearning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.elearning.model.User;
import com.elearning.repository.UserRepository;
import com.mongodb.MongoClient;


@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.elearning"})
@EnableMongoRepositories(basePackages={"com.elearning.repository"})
@Import(RepositoryRestMvcConfiguration.class)
public class ApplicationConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;

		public static void main(String[] args) {
			SpringApplication.run(ApplicationConfig.class, args);
		}
	 
		@Override
		public void run(String... args) throws Exception {
	/*		this.repository.deleteAll();

			// save a couple of customers
			this.repository.save(new User("user1", "Alice", "Smith","addr1","9992230234"));
			this.repository.save(new User("user2", "Bob", "Smith","addr2","9999999999"));
			
			
			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (User customer : this.repository.findAll()) {
				System.out.println(customer);
			}
			System.out.println();

			// fetch an individual customer
			System.out.println("Customer found with findByFirstName('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(this.repository.findByFirstName("Alice"));

			System.out.println("Customers found with findByLastName('Smith'):");
			System.out.println("--------------------------------");
			for (User customer : this.repository.findByLastName("Smith")) {
				System.out.println(customer);
			}*/
		}
	
    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        return new SimpleMongoDbFactory(mongoClient, "elearning");
    }
 
    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
     
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
  
        return viewResolver;
    }
}