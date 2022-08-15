package org.simplilearn.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@NamedQueries(value = {
		@NamedQuery(name = "Product.findByName",
				query = "select p from org.simplilearn.app.entities.Product p where p.name=?1"),
		@NamedQuery(name = "Product.findByPriceBetween",
		query = "select p from org.simplilearn.app.entities.Product p where p.price between ?1 and ?2")
})*/
/*@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Product.findByName",query = "select * from product p where p.name=?",resultClass = Product.class)
})*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String description;
	private int price;
	private String imageUrl;
	@CreatedDate
	private LocalDateTime dateCreated;
	@LastModifiedDate
	private LocalDateTime lastUpdated;
}
