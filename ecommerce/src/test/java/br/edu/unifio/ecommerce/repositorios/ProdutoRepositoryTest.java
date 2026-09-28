package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Categoria;
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
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributosERelacionamento() {
        // 1. Cria e persiste a Categoria
        Categoria categoria = new Categoria();
        categoria.setNome("Eletrônicos");
        categoria.setDescricao("Produtos eletrônicos");
        categoria = entityManager.persist(categoria);

        // 2. Cria e persiste o Produto (ID Integer)
        Produto produto = new Produto();
        produto.setId(1); // ID como Integer (sem o L)
        produto.setNome("Smartphone");
        produto.setDescricao("Celular Top");
        produto.setPreco(new BigDecimal("1500.00"));
        produto.setEstoque((short) 10);
        produto.setCategoria(categoria);
        produto = entityManager.persist(produto);
        entityManager.flush();

        // 3. Busca pelo ID do produto criado
        Optional<Produto> resultado = produtoRepository.findById(produto.getId());

        // 4. Asserções
        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("Smartphone", resultado.get().getNome());
        Assertions.assertNotNull(resultado.get().getCategoria());
        Assertions.assertEquals("Eletrônicos", resultado.get().getCategoria().getNome());
    }

    @Test
    public void listarRegistrosDeveRetornarListaComQuantidadeCorreta() {
        // 1. Cria e persiste um Produto (ID Integer)
        Produto produto = new Produto();
        produto.setId(1); // ID como Integer (sem o L)
        produto.setNome("Teclado");
        produto.setPreco(new BigDecimal("100.00"));
        produto.setEstoque((short) 5);
        entityManager.persist(produto);
        entityManager.flush();

        // 2. Executa a busca
        List<Produto> lista = produtoRepository.findAll();

        // 3. Asserção
        Assertions.assertFalse(lista.isEmpty());
    }
}