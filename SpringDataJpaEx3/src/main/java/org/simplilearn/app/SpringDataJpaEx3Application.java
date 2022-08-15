package org.simplilearn.app;

import org.simplilearn.app.entities.Product;
import org.simplilearn.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaEx3Application {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaEx3Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner()
	{
		CommandLineRunner runner=(String ...s)->{
			Product p1=new Product();
			p1.setName("Laptop");
			p1.setDescription("Lenovo thinkpad");
			p1.setPrice(50000);
			p1.setImageUrl("ysdgyuasgfdhfhds8f");
			Product p2=new Product();
			p2.setName("Camera");
			p2.setDescription("camera");
			p2.setPrice(30000);
			p2.setImageUrl("ysdgyuasgfdhfhds8f");
			productRepository.save(p1);
			productRepository.save(p2);
			Product product= productRepository.findProductByName("Laptop");
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getPrice());
		};
		return runner;
	}

}
