package br.com.etec.fluxocaixa.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Movimentacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipo;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Contas conta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;
}