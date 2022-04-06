package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "O nome do assunto nao pode ficar vazio.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do assunto deve começar com letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome do assunto não pode exceder 30 caracteres.")
    String name;

    @NotNull(message = "A nota nao pode estar vazia.")
    @DecimalMin(value = "0.0", message = "A nota minima e 0,0")
    @DecimalMax(value= "10.0", message = "A nota maxima e 10,00")
    Double score;
}
