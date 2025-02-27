package foro.Alura.api.domain.topico.DTO;

import foro.Alura.api.domain.topico.Enum.Curso;
import foro.Alura.api.domain.topico.Enum.Status;
import foro.Alura.api.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico (
        Long id,
        String autor,
        String mensaje,
        String titulo,
        LocalDateTime fecha,
        Status status,
        Curso curso) {

    public DatosListadoTopico (Topico topico){
        this(
                topico.getId(),
                topico.getAutor(),
                topico.getMensaje(),
                topico.getTitulo(),
                topico.getFechaDeCreacion(),
                topico.getStatus(),
                topico.getCurso()
        );
    }

}
