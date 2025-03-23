// package com.ecommerce.ecommerce_backend.server;

// import com.stripe.Stripe;
// import com.stripe.exception.StripeException;
// import com.stripe.model.Product;
// import com.stripe.param.ProductCreateParams;
// import com.stripe.param.PriceCreateParams;
// import com.stripe.model.Price;

// public class StripeServer {
//     private String apiKey;
    
//     this.apiKey = "sk_test_51R5pQfRFfrJmeZvqFmul4J1H89TML8mTPzweEeN8MDAbxelrKIVSGYZcOCFFQVUEOsduBnp5pOrKAIju6HuYy406001TE3WkWZ";
//     public void  throws StripeException {
        

//         ProductCreateParams productParams =
//             ProductCreateParams.builder()
//                 .setName("Starter Subscription")
//                 .setDescription("$12/Month subscription")
//                 .build();
//         Product product = Product.create(productParams);
//         System.out.println("Success! Here is your starter subscription product id: " + product.getId());

//         PriceCreateParams params =
//             PriceCreateParams
//                 .builder()
//                 .setProduct(product.getId())
//                 .setCurrency("usd")
//                 .setUnitAmount(1200L)
//                 .setRecurring(
//                     PriceCreateParams.Recurring
//                         .builder()
//                         .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
//                         .build())
//                 .build();
//         Price price = Price.create(params);
//         System.out.println("Success! Here is your starter subscription price id: " + price.getId());
//     }
// }


