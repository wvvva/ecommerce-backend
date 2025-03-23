package com.ecommerce.ecommerce_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ecommerce.ecommerce_backend.entity.Item;
import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.ItemRepository;
import com.ecommerce.ecommerce_backend.repository.UserRepository;

@EnableJpaRepositories(basePackages = "com.ecommerce.ecommerce_backend.repository")
@EntityScan(basePackages = "com.ecommerce.ecommerce_backend.entity")
@SpringBootApplication
public class EcommerceBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceBackendApplication.class, args);
	}

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception{
		Item item1 = Item.builder()
					.itemName("firstItem")
					.price(10)
					.quantity(10)
					.build();
		Item item2 = Item.builder()
					.itemName("secItem")
					.price(10)
					.quantity(10)
					.build();
		Item item3 = Item.builder()
					.itemName("thirdItem")
					.price(25)
					.quantity(10)
					.build();	
		Item item4 = Item.builder()
					.itemName("book")
					.price(30)
					.quantity(10)
					.build();
		Item item5 = Item.builder()
					.itemName("frame")
					.price(10)
					.quantity(10)
					.build();	

		User user1 = User.builder()
					.username("firstUser")
					.password("1234567")
					.build();
		
		itemRepository.save(item1);
		itemRepository.save(item2);
		itemRepository.save(item3);
		itemRepository.save(item4);
		itemRepository.save(item5);
		
		userRepository.save(user1);

	}
}
