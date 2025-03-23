package com.ecommerce.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce_backend.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
