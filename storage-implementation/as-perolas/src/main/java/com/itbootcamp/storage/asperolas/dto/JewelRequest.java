package com.itbootcamp.storage.asperolas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelRequest {
    @NotBlank(message = "O argumento material não pode ser vázio.")
    private String material;
    @NotNull(message = "O argumento weight não pode ser nulo.")
    @Positive(message = "O argumento weight não pode ser negativo.")
    private Double weight;
    @NotNull(message = "O argumento carats não pode ser nulo.")
    @Positive(message = "O argumento carats não pode ser negativo.")
    private Double carats;

}
