package foro.Alura.api.domain.topico.Service;



import foro.Alura.api.domain.topico.DTO.DatosActualizarTopico;
import foro.Alura.api.domain.topico.DTO.DatosDetalleTopico;
import foro.Alura.api.domain.topico.DTO.DatosListadoTopico;
import foro.Alura.api.domain.topico.DTO.DatosRegistroTopico;
import foro.Alura.api.domain.topico.Topico;
import foro.Alura.api.domain.topico.TopicoRepository;
import foro.Alura.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServices {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico agregarTopico(DatosRegistroTopico datos){
        var response = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        if(response){
            throw new ValidacionDeIntegridad("""
                    No se permite el registro de tópicos duplicados
                    """);
        }
        Topico topico = topicoRepository.save(new Topico(datos));
        topicoRepository.save(topico);
        return topico;
    }

    public DatosDetalleTopico obtenerTopico (Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosDetalleTopico(topico);
        return  datosTopico;
    }

    public Page<DatosListadoTopico> listadoTopicos (Pageable paginacion){
        var response = topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return response;
    }

    public DatosDetalleTopico actualizarTopico (Long id, DatosActualizarTopico datos){
        Optional <Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){

            var response = topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
            if(response) {
                throw new ValidacionDeIntegridad("""
                        No se permite el registro de tópicos duplicados
                        """);
            }
            topico.get().actualizarDatos(datos);
            return new DatosDetalleTopico(topico.get());
        }else {
                throw new ValidacionDeIntegridad("""
                        No se encuentra trópico con el ID ingresado
                        """);
            }
    }

    public void eliminarTopico(Long id){
        Optional <Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){

            topicoRepository.deleteById(id);

        }else {
            throw new ValidacionDeIntegridad("""
                        No se encuentra trópico con el ID ingresado
                        """);
        }
    }

}
