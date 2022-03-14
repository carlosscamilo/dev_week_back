package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.FaixaEtaria;
import com.dio_class.devweek.Repository.FaixaEtariaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class FaixaEtariaController {

    @Autowired
    private FaixaEtariaRepo fRepository;

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = fRepository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<FaixaEtaria> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = fRepository.findById(id);
            if (unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixa) {

        return fRepository.save(newFaixa);
    }

    @DeleteMapping("/faixaetaria/{id}")
    public void deleteFaixaEtaria(@PathVariable long id){
        fRepository.deleteById(id);
    }

}
