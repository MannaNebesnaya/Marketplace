package ru.marketplace.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.User;

@Transactional(readOnly = true)
public interface CrudUserRepository extends JpaRepository<User, Integer> {


    @Query("SELECT u FROM User u JOIN FETCH u.products WHERE u.id=:userId")
    User getWithProducts(@Param("userId") int userId);
}
