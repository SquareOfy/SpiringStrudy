package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNameLike(String itemName);

    List<Item> findByPriceLessThenEqual(Integer price);

    //쿼리 메서드
    List<Item> findByItemNameLikeAndPriceLessThenEqual(String itemName, Integer price);

    //쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price<= :price")
    List<Item> findItem(@Param("itemName") String itemName, @Param("price") Integer price);

    //조건없이 검색하는건 내장된 findAll 메서드 사용
}
