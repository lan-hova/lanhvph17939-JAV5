package ASM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ASM.entities.Accounts;


@Repository
public interface AccountRepository 
	extends JpaRepository<Accounts, Integer> {
		
	@Query(value="SELECT acc FROM Accounts acc " 
			+"WHERE acc.email = :email")
	public Accounts findByEmail(@Param("email")String email);
	
}
