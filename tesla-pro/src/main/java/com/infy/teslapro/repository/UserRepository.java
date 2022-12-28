package com.infy.teslapro.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.infy.teslapro.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findByEmail(String email);

	 User findByFirstName(String username);
}
