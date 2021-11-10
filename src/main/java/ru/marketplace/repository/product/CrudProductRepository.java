package ru.marketplace.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.Product;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    @Override
    Product save(Product product);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM products WHERE id=?1 AND user_id=?2", nativeQuery = true)
    int delete(int id, int userId);


    //А нужно ли нам вытаскивать User в данном случае с City?
    @Query("SELECT p FROM Product p JOIN FETCH p.user WHERE p.id=:id")
    Product getWithUser(@Param("id") int id);


    @Query(value = "SELECT * FROM products WHERE user_id=?1 ORDER BY registered DESC", nativeQuery = true)
    List<Product> getAllByUserId(int userId);
}
