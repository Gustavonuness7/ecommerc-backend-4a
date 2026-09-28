package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Pagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class PagamentoRepositoryTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributosERelacionamento() {
        Optional<Pagamento> resultado = pagamentoRepository.findById(1);

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("PIX", resultado.get().getTipo());
        Assertions.assertEquals("AGUARDANDO", resultado.get().getStatus());
        
        Assertions.assertNotNull(resultado.get().getPedido());
        Assertions.assertEquals(1, resultado.get().getPedido().getId());
    }

    @Test
    public void listarRegistrosDeveRetornarListaComQuantidadeCorreta() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();

        Assertions.assertFalse(pagamentos.isEmpty());
        Assertions.assertEquals(5, pagamentos.size());
    }
}