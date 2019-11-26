package br.com.gerenciadorproposta.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Representa uma proposta no sistema.")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proposta {

    @ApiModelProperty(value = "Código da proposta", example = "1", accessMode = AccessMode.READ_ONLY, readOnly = true)
    @Id
    @GeneratedValue
    private Long id;

    @ApiModelProperty(value = "Descrição", example = "Implementação de sistema de autenticação")
    @NotEmpty
    private String descricao;

    @ApiModelProperty(value = "Valor", example = "7500.00")
    @NotNull
    private Double valor;

    @ApiModelProperty(value = "Data", example = "2019-12-04")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate data;

    @ApiModelProperty(value = "Status")
    private Status status;

    @ApiModelProperty(hidden = true)
    @NotNull
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
}
