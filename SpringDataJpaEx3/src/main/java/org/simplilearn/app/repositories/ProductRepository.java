package org.simplilearn.app.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.simplilearn.app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query(value = "select * from product p where p.name=?1",nativeQuery = true)
	//@Query(value = "select p from org.simplilearn.app.entities.Product p where p.name=?1")
	Product findProductByName(String name);
	Optional<Product> findByPid(int id);
	Product findByNameAndDescription(String name,String description);
	List<Product> findByDateCreatedAfter(LocalDateTime localDateTime);
	List<Product> findByPriceGreaterThan(int price);
	List<Product> findByNameContaining(String name);
	List<Product> findByPriceBetween(int startPrice,int endPrice);
}
