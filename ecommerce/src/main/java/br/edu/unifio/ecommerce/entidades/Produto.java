package br.edu.unifio.ecommerce.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Produto {
@Id
private Integer id;

private String nome;

private String descricao;

private short estoque;

private BigDecimal preco;

@ManyToOne

private Categoria categoria;
}
