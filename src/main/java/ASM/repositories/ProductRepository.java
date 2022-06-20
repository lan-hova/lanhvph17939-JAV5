package ASM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ASM.entities.Products;

@Repository
public interface ProductRepository 
		extends JpaRepository<Products, Integer>{

}
