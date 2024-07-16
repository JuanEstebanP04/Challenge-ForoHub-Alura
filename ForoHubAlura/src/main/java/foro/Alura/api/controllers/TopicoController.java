package foro.Alura.api.controllers;

import foro.Alura.api.domain.topico.DTO.DatosActualizarTopico;
import foro.Alura.api.domain.topico.DTO.DatosDetalleTopico;
import foro.Alura.api.domain.topico.DTO.DatosListadoTopico;
import foro.Alura.api.domain.topico.DTO.DatosRegistroTopico;
import foro.Alura.api.domain.topico.Service.TopicServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicServices servicio;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                          UriComponentsBuilder uriComponentsBuilder){
        var response = servicio.agregarTopico(datos);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.getId()).toUri();
        DatosDetalleTopico datosDetalleTopico = new DatosDetalleTopico(response);
        return ResponseEntity.created(url).body(datosDetalleTopico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerTopico(@PathVariable Long id){
        var response = servicio.obtenerTopico(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listaDeMedicos(@PageableDefault(size = 2) Pageable paginacion){
        var response = servicio.listadoTopicos(paginacion);
        return ResponseEntity.ok(response);
    }

    @PutMapping ("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
        var response = servicio.actualizarTopico(id,datosActualizarTopico);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> eliminarTopico(@PathVariable Long id){
        servicio.eliminarTopico(id);
        return  ResponseEntity.noContent().build();
    }

}
