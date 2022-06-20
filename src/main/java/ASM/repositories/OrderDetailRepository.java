package ASM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ASM.entities.OrderDetails;

@Repository
public interface OrderDetailRepository
				extends JpaRepository<OrderDetails, Integer>{

}
