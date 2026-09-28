package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.ItemPedido;
import br.edu.unifio.ecommerce.entidades.Pedido;
import br.edu.unifio.ecommerce.entidades.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ItemPedidoRepositoryTest {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributosERelacionamentos() {
        // 1. Cria Cliente e Pedido
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
        cliente.setEmail("carlos@email.com");
        cliente = entityManager.persist(cliente);

        Pedido pedido = new Pedido();
        pedido.setStatus("PENDENTE");
        pedido.setCliente(cliente);
        pedido = entityManager.persist(pedido);

        // 2. Cria Produto (ID Integer)
        Produto produto = new Produto();
        produto.setId(1); // ID como Integer (sem o L)
        produto.setNome("Monitor");
        produto.setPreco(new BigDecimal("800.00"));
        produto.setEstoque((short) 20);
        produto = entityManager.persist(produto);

        // 3. Cria e persiste o ItemPedido
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(new BigDecimal("800.00"));
        itemPedido = entityManager.persist(itemPedido);
        entityManager.flush();

        // 4. Executa a busca pelo ID
        Optional<ItemPedido> resultado = itemPedidoRepository.findById(itemPedido.getId());

        // 5. Asserções
        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals(2, resultado.get().getQuantidade());
        Assertions.assertNotNull(resultado.get().getPedido());
        Assertions.assertNotNull(resultado.get().getProduto());
    }

    @Test
    public void listarRegistrosDeveRetornarListaComQuantidadeCorreta() {
        // 1. Cria entidades dependentes
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente = entityManager.persist(cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido = entityManager.persist(pedido);

        Produto produto = new Produto();
        produto.setId(1); // ID como Integer (sem o L)
        produto.setNome("Mouse");
        produto.setPreco(new BigDecimal("50.00"));
        produto.setEstoque((short) 10);
        produto = entityManager.persist(produto);

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(1);
        item.setValorUnitario(new BigDecimal("50.00"));
        entityManager.persist(item);
        entityManager.flush();

        // 2. Busca lista
        List<ItemPedido> lista = itemPedidoRepository.findAll();

        // 3. Asserção
        Assertions.assertFalse(lista.isEmpty());
    }
}