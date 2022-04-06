package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "O nome do aluno nao pode ficar vazio.")
    @Size(max = 50, message = "O comprimento do nome nao pode exceder 50 caracteres.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ]+", message = "O nome do aluno deve começar com letra maiúscula.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "A lista de assuntos não pode ficar vazia.")
    List<@Valid SubjectDTO> subjects;
}
