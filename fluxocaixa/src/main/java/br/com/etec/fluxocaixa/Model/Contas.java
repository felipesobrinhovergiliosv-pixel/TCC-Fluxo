package br.com.etec.fluxocaixa.Model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

// contas no geral, tanto a pagar qunato a receber//
@Entity
@Table(name = "contas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    // Tipo da movimentação: pagar ou receber
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_movimentacao_id", nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    // Se for conta a pagar, o fornecedor deve ser preenchido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedores fornecedor;

    // Se for conta a receber, o cliente deve ser preenchido
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    public BigDecimal getValorComSinal() {
        if (tipoMovimentacao != null && tipoMovimentacao.get.equalsIgnoreCase("PAGAR")) {
            return valor.negate(); // torna negativo
        }
        return valor; // mantém positivo
    }
}