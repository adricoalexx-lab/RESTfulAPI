package com.projects.restapi.controller;

import com.projects.restapi.models.Obat;
import com.projects.restapi.repository.ObatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private ObatRepo obatRepo;

    //Show All
    @GetMapping(value = "/list")
    public List<Obat> getObat(){
        return obatRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String createObat(@RequestBody Obat obat){
        obatRepo.save(obat);
        return "Saved....";
    }

    @PutMapping(value = "/update/{id}")
    public String updateObat(@PathVariable long id, @RequestBody Obat obat){
        Obat updateObat = obatRepo.findById(id).get();
        updateObat.setNamaObat(obat.getNamaObat());
        updateObat.setJenis(obat.getJenis());
        updateObat.setHarga(obat.getHarga());
        obatRepo.save(updateObat);
        return "Updatedd....";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteObat(@PathVariable long id){
        Obat deleteObat = obatRepo.findById(id).get();
        obatRepo.delete(deleteObat);
        return "Deleted obat with id "+id;
    }
}
