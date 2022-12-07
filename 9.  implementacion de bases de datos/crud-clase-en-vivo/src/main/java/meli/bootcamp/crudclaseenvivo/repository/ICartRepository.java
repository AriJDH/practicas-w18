package meli.bootcamp.crudclaseenvivo.repository;

import meli.bootcamp.crudclaseenvivo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
