package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributos() {
        Optional<Cliente> resultado = clienteRepository.findById(1);

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("Ana Silva", resultado.get().getNome());
        Assertions.assertEquals("ana.silva@email.com", resultado.get().getEmail());
    }

    @Test
    public void listarRegistrosDeveRetornarListaComQuantidadeCorreta() {
        List<Cliente> clientes = clienteRepository.findAll();

        Assertions.assertFalse(clientes.isEmpty());
        Assertions.assertEquals(5, clientes.size());
    }
}