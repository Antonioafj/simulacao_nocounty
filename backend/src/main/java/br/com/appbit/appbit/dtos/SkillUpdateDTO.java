package br.com.appbit.appbit.dtos;

import jakarta.validation.constraints.NotBlank;

public record SkillUpdateDTO(

        @NotBlank(message = "O nome da skill é obrigatório")
        String nome,

        String categoria
) {
}
