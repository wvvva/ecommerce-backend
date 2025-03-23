package com.ecommerce.ecommerce_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_backend.entity.Item;
import com.ecommerce.ecommerce_backend.repository.ItemRepository;



@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")    
    public List<Item> fetchItems(){
        return itemRepository.findAll();
    }

    // @PostMapping("/items/add")
    // public Item addItem(@RequestParam("username") String username, @RequestParam("password") String password) {
    //     User user = User.builder()
    //                 .username(username)
	// 				.password(password)
	// 				.build();
                    
    //     return userRepository.save(user);
    // }

    // @PostMapping("/users/delete")
    // public void deleteUser(@RequestParam("userid") Long id) {
    //     Optional<User> optionalUser = userRepository.findById(id);
    //     User user = optionalUser.get();
    //     userRepository.delete(user);
    // }
    
}
