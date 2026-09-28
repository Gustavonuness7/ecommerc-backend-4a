package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}