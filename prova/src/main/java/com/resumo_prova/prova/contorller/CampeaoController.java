package com.resumo_prova.prova.contorller;

import com.resumo_prova.prova.model.CampeaoModel;
import com.resumo_prova.prova.service.CampeaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/campeoes")
public class CampeaoController {
    @Autowired
    private CampeaoService service;

    @PostMapping
    public CampeaoModel save(@Valid @RequestBody CampeaoModel campeaoModel){
        return service.save(campeaoModel);
    }

    @GetMapping
    public List<CampeaoModel>listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<CampeaoModel>buscaPorId(@PathVariable UUID id){
        return service.buscaPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<CampeaoModel>findByNome(@PathVariable String nome){
        return service.buscaPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        service.deletar(id);
    }

    @PutMapping("/{id}")
    public CampeaoModel atualizar(@PathVariable UUID id, @RequestBody CampeaoModel campeaoModel){
        campeaoModel.setId(id);
        return service.save(campeaoModel);
    }
}
