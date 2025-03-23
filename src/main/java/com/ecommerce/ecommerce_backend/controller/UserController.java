package com.ecommerce.ecommerce_backend.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_backend.entity.Item;
import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.ItemRepository;
import com.ecommerce.ecommerce_backend.repository.UserRepository;



@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/users")    
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/users/add")
    public User addUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Optional<User> existingUser = userRepository.findByUsername(username);
        if (existingUser.isPresent()) {
            return null; 
        }
        User user = User.builder()
                    .username(username)
					.password(password)
                    .itemList(new LinkedList<>())
					.build();
                    
        return userRepository.save(user);
    }

    // @PostMapping("/users/delete")
    // public void deleteUser(@RequestParam("userid") Long id) {
    //     Optional<User> optionalUser = userRepository.findById(id);
    //     User user = optionalUser.get();
    //     userRepository.delete(user);
    // }

    @PostMapping("/users/verify")
    public User verifyUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        return optionalUser.orElse(null);
    }

    @PostMapping("/users/addItem")
    public User addItem(@RequestParam("userId") Long userId, @RequestParam("itemId") Long itemId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (!existingUser.isPresent()) {
            return null; 
        }
        
        List<Item> itemList = existingUser.get().getItemList();
        Item item = itemRepository.findById(itemId).get();
        if (itemList.contains(item)){
            item.setQuantityInCart(item.getQuantityInCart() + 1);
        } else {
            item.setUser(existingUser.get());
            itemList.add(item);
            item.setQuantityInCart(1);
        }
        existingUser.get().setItemList(itemList);
        userRepository.save(existingUser.get());
        itemRepository.save(item);
        return existingUser.get();
    }

    @GetMapping("/getItems")    
    public List<Item> getItems(@RequestParam("userId") Long userId){
        User existingUser = userRepository.findById(userId).get();
        return existingUser.getItemList();
    }
    
}
