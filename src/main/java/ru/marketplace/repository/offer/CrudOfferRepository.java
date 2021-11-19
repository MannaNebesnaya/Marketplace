package ru.marketplace.repository.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.Offer;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudOfferRepository extends JpaRepository<Offer, Integer> {

    @Transactional
    @Override
    Offer save(Offer offer);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM offers WHERE id=?1 AND user_id=?2", nativeQuery = true)
    int delete(int id, int userId);


    List<Offer> findByNameStartingWith(String name);


    @Query("SELECT o FROM Offer o JOIN FETCH o.category WHERE o.category.name=:categoryName")
    List<Offer> getByCategory(@Param("categoryName") String categoryName);

    //А нужно ли нам вытаскивать User в данном случае с City?
    @Query("SELECT p FROM Offer p JOIN FETCH p.user WHERE p.id=:id")
    Offer getWithUser(@Param("id") int id);


    @Query(value = "SELECT * FROM offers WHERE user_id=?1 ORDER BY registered DESC", nativeQuery = true)
    List<Offer> getAllByUserId(int userId);
}
