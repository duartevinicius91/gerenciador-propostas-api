package br.com.gerenciadorproposta.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel
@Getter
public enum Status {

    APROVADA("Aprovada"), RECUSADA("Recusada"), EM_ANÁLISE("Em análise");

    private String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

}