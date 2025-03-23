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
					.itemName("NETANY Drinking Glasses with Glass Straw 4pcs Set")
					.price(1498)
					.quantity(60)
					.imageUrl("https://m.media-amazon.com/images/I/71Gg7kaWiWL.__AC_SX300_SY300_QL70_FMwebp_.jpg")
					.priceId("price_1R5qhYRFfrJmeZvqw1vqHMGi")
					.build();
		Item item2 = Item.builder()
					.itemName("Replacement Straw Compatible with Stanley")
					.price(599)
					.quantity(200)
					.imageUrl("https://m.media-amazon.com/images/I/61Od2GTm9WL._AC_UL640_QL65_.jpg")
					.priceId("price_1R5qitRFfrJmeZvqO5r5cP36")
					.build();
		Item item3 = Item.builder()
					.itemName("OXO Good Grips Large Salad Spinner")
					.price(2495)
					.quantity(50)
					.imageUrl("https://m.media-amazon.com/images/I/61VccS4G-PL.__AC_SX300_SY300_QL70_FMwebp_.jpg")
					.priceId("price_1R5qkeRFfrJmeZvqDSVAVwth")
					.build();	
		Item item4 = Item.builder()
					.itemName("Keurig K-Classic Single Serve K-Cup Pod Coffee Maker")
					.price(9999)
					.quantity(40)
					.imageUrl("https://m.media-amazon.com/images/I/61wQb8IB8UL._AC_SX679_.jpg")
					.priceId("price_1R5qmjRFfrJmeZvqz6OrmZiS")
					.build();
		Item item5 = Item.builder()
					.itemName("Shark Upright Vacuum")
					.price(12999)
					.quantity(70)
					.imageUrl("https://m.media-amazon.com/images/I/71ybuaqVLwL._AC_SX679_.jpg")
					.priceId("price_1R5qngRFfrJmeZvq2GrVcZXj")
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
