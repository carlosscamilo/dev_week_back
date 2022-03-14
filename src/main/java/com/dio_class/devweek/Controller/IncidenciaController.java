package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.IncidenciaExame;
import com.dio_class.devweek.Repository.IncidenciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class IncidenciaController {

    @Autowired
    private IncidenciaRepo icRepository;

    @GetMapping("/incidencia")
    public ResponseEntity<List<IncidenciaExame>> findOcorrencias(){
        List<IncidenciaExame> listaOcorrencia = icRepository.findAll();
        if (listaOcorrencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(listaOcorrencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> ocorrenciaOptional = icRepository.findById(id);
        if (ocorrenciaOptional.isPresent()){
            IncidenciaExame ocorrenciaUnid = ocorrenciaOptional.get();
            return new ResponseEntity<>(ocorrenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencia/novo")
    public IncidenciaExame newIncidencia(@RequestBody IncidenciaExame incidencia){
        return icRepository.save(incidencia);
    }

}
