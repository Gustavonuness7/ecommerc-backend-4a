package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}