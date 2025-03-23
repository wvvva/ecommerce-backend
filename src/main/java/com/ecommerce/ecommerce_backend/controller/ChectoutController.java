package com.ecommerce.ecommerce_backend.controller;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_backend.entity.Item;
import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping("/api")
public class ChectoutController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/checkout")    
    public String checkout(@RequestParam("userId") Long userId) throws StripeException{
        Stripe.apiKey = "sk_test_51R5pQfRFfrJmeZvqFmul4J1H89TML8mTPzweEeN8MDAbxelrKIVSGYZcOCFFQVUEOsduBnp5pOrKAIju6HuYy406001TE3WkWZ";
        String YOUR_DOMAIN = "http://localhost:4242";

        User user = userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("User not found"));

        List<SessionCreateParams.LineItem> lineItems = new LinkedList<>();

        for (Item item : user.getItemList()) {
            SessionCreateParams.LineItem lineItem = SessionCreateParams.LineItem.builder()
                    .setQuantity((long) item.getQuantityInCart()) 
                    .setPrice(item.getPriceId())
                    .build();
            lineItems.add(lineItem); 
        }

        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
            .addAllLineItem(lineItems) 
            .build();

        Session session = Session.create(params);

        return session.getUrl();
    }
}
