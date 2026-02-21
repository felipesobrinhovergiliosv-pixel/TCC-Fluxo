package br.com.etec.fluxocaixa.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TipoMovimentacaoDto {
    private String tipoMovimentacao;
}
