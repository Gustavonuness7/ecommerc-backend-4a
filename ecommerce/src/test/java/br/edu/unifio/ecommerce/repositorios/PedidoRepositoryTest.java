package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
public class PedidoRepositoryTest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributosERelacionamento() {
        
        Cliente cliente = new Cliente();
        cliente.setNome("Ana Silva");
        cliente.setEmail("ana.silva@email.com");
        cliente = entityManager.persist(cliente);

        
        Pedido pedido = new Pedido();
        pedido.setStatus("PENDENTE");
        pedido.setCliente(cliente);
        pedido = entityManager.persist(pedido);
        entityManager.flush();

       
        Optional<Pedido> resultado = pedidoRepository.findById(pedido.getId());

        
        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("PENDENTE", resultado.get().getStatus());
        Assertions.assertNotNull(resultado.get().getCliente());
        Assertions.assertEquals("Ana Silva", resultado.get().getCliente().getNome());
    }
}