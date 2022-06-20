package ASM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ASM.entities.Orders;

@Repository
public interface OrderRepository 
				extends JpaRepository<Orders, Integer>{

}
