package br.edu.unifio.ecommerce.repositorios;

import br.edu.unifio.ecommerce.entidades.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void buscarPorIdDeveRetornarObjetoEValidarAtributos() {
        Optional<Categoria> resultado = categoriaRepository.findById(1);

       Assertions.assertTrue(resultado.isPresent());
Assertions.assertEquals("Eletrônicos", resultado.get().getNome());
Assertions.assertEquals((short) 1, resultado.get().getId());
    }

    @Test
    public void listarRegistrosDeveRetornarListaComQuantidadeCorreta() {
        List<Categoria> categorias = categoriaRepository.findAll();

        Assertions.assertFalse(categorias.isEmpty());
        Assertions.assertEquals(5, categorias.size());
    }
}