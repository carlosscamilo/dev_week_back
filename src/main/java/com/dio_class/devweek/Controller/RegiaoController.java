package com.dio_class.devweek.Controller;

import com.dio_class.devweek.Entity.Regiao;
import com.dio_class.devweek.Repository.RegiaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegiaoController {

    @Autowired
    private RegiaoRepo regiaoRepo;

    @GetMapping("/regiao")
    public List<Regiao> getRegiao(){
        return regiaoRepo.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id) {
        Optional regiaoEscolhidaOptional = regiaoRepo.findById(id);
        if (regiaoEscolhidaOptional.isPresent()){
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public void putRegiao(@RequestBody Regiao newRegiao){
        regiaoRepo.save(newRegiao);
    }



    @DeleteMapping("/regiao/delete/{id}")
    public void deleteRegiao(@PathVariable Long id){
        regiaoRepo.deleteById(id);
    }
}