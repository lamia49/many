package com.example.onetoone.Service;

import com.example.onetoone.Api.ApiExepstion;
import com.example.onetoone.Model.Mearchent;
import com.example.onetoone.Rebositry.MerchentRebositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MerchentService {
    private final MerchentRebositry merchentRebositry;

    public List<Mearchent> get(){
        return merchentRebositry.findAll();
    }

    public void add(Mearchent mearchent){
        merchentRebositry.save(mearchent);
    }

    public void update(Integer id ,Mearchent mearchent){
        Mearchent mearchent1=merchentRebositry.findMearchentById(id);
        if(mearchent1==null) {
            throw new ApiExepstion("not found");
        }
            mearchent1.setName(mearchent.getName());
            merchentRebositry.save(mearchent1);
    }

    public void delete(Integer id){
        Mearchent mearchent=merchentRebositry.findMearchentById(id);
        if(mearchent==null) {
            throw new ApiExepstion("not found");
        }
        merchentRebositry.delete(mearchent);
    }

}
