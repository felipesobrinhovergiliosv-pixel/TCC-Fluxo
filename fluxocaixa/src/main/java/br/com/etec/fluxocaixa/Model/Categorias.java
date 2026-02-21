package br.com.etec.fluxocaixa.Model;
import jakarta.persistence.*;

@Entity
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo; // ENTRADA ou SAIDA

    // getters e setters
}
