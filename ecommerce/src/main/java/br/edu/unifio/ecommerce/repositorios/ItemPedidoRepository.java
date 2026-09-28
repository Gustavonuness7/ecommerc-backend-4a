package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}