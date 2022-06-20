package ASM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ASM.entities.Categories;

@Repository
public interface CategoryRepository 
		extends  JpaRepository<Categories, Integer> {
	
}
 