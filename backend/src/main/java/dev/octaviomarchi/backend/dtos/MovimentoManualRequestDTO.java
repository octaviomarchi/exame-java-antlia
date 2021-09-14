package dev.octaviomarchi.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovimentoManualRequestDTO {

    @NotNull
    @Pattern(regexp = "^(0?[1-9]{1}|1[012])$", message = "mes precisa ser entre 1 e 12")
    private String mes;

    @NotNull
    @Pattern(regexp = "^\\d{1,4}$", message = "ano precisa ser um numero de 1 a 4 digitos")
    private String ano;

    @NotNull
    private String produto;

    @NotNull
    private String cosif;

    @NotNull
    private Double valor;

    @NotNull
    private String descricao;
}
