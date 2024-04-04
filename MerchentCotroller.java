package com.example.onetoone.Controller;

import com.example.onetoone.Model.Mearchent;
import com.example.onetoone.Service.MerchentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchent")
@AllArgsConstructor

public class MerchentCotroller {

    public final MerchentService merchentService;



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid  Mearchent mearchent){
        merchentService.add(mearchent);
        return ResponseEntity.status(200).body("added");
    }



    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(merchentService.get());
    }



    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody @Valid Mearchent mearchent){
        merchentService.update(id,mearchent);
        return ResponseEntity.status(200).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        merchentService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }
}
