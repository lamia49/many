package com.example.onetoone.Controller;

import com.example.onetoone.Model.Branch;
import com.example.onetoone.Service.BranchService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@AllArgsConstructor
public class BranchController {
    private final BranchService branchService;


    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(branchService.get());
    }


    @PostMapping("/add/{mearchentID}")
    public ResponseEntity add(@PathVariable Integer mearchentID,@RequestBody @Valid Branch branch){

        branchService.add(mearchentID,branch);
        return ResponseEntity.status(200).body("added");
    }

@PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Branch branch){
        branchService.update(id,branch);
        return ResponseEntity.status(200).body("updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
    branchService.delete(id);
        return ResponseEntity.status(200).body("deleted");
    }


//    @PutMapping("/assign/{mearchenId}/{branchID}")
//    public ResponseEntity assignMerchent(@PathVariable Integer mearchenId,@PathVariable Integer branchID){
//        branchService.assignMerchentToBranch(mearchenId,branchID);
//        return ResponseEntity.status(200).body("assign done");
//    }

}
