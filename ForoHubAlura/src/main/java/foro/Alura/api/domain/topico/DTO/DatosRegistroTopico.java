package foro.Alura.api.domain.topico.DTO;

import foro.Alura.api.domain.topico.Enum.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String idusuario,
        @NotBlank
        String mensaje,
        @NotNull
        Curso curso,
        @NotBlank
        String titulo
) {
}
