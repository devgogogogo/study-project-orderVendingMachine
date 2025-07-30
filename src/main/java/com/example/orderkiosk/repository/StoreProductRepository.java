package com.example.orderkiosk.repository;

import com.example.orderkiosk.domain.StoreProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreProductRepository extends CrudRepository<StoreProduct, Integer> {

    Optional<StoreProduct> findByStoreIdAndProductId(int storeId, int productId);
}
