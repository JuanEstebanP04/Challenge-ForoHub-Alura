package foro.Alura.api.domain.topico.DTO;

import foro.Alura.api.domain.topico.Enum.Curso;
import foro.Alura.api.domain.topico.Enum.Status;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        Curso curso,
        Status status
) {
}
