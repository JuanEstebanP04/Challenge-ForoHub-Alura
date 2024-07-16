package foro.Alura.api.domain.topico;

import foro.Alura.api.domain.topico.DTO.DatosActualizarTopico;
import foro.Alura.api.domain.topico.DTO.DatosRegistroTopico;
import foro.Alura.api.domain.topico.Enum.Curso;
import foro.Alura.api.domain.topico.Enum.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaDeCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaDeCreacion = LocalDateTime.now();
        this.status = Status.SIN_RESPUESTA;
        this.autor = datos.idusuario();
        this.curso = datos.curso();
    }

    public void actualizarDatos(DatosActualizarTopico datos){
        if(datos.titulo() != null){
            this.titulo = datos.titulo();}
        if(datos.mensaje() != null){
            this.mensaje = datos.mensaje();}
        if (datos.curso() != null){
            this.curso = datos.curso();
        }
        if (datos.status() != null){
            this.status = datos.status();
        }
        this.fechaDeCreacion = LocalDateTime.now();
    }
}
