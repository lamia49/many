package com.example.onetoone.Service;

import com.example.onetoone.Api.ApiExepstion;
import com.example.onetoone.Model.Branch;
import com.example.onetoone.Model.Mearchent;
import com.example.onetoone.Rebositry.BranchRebositry;
import com.example.onetoone.Rebositry.MerchentRebositry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchService {
   private final BranchRebositry branchRebositry;
   private  final MerchentRebositry merchentRebositry;

   public List<Branch> get(){
      return branchRebositry.findAll();
   }

   public void add(Integer merchenrID ,Branch branch){
       Mearchent mearchent=merchentRebositry.findMearchentById(merchenrID);
       if(mearchent==null){
           throw new ApiExepstion("merchenr id not not found");
       }
       branch.setMearchent(mearchent);
       branchRebositry.save(branch);
   }

   public void update(Integer id, Branch branch){
       Branch branch1=branchRebositry.findBranchById(id);
       if(branch1==null){
           throw new ApiExepstion("not found");
       }
       branch1.setArea(branch.getArea());
       branch1.setNumber(branch.getNumber());
       branchRebositry.save(branch1);
   }

   public void delete(Integer id){
       Branch branch1=branchRebositry.findBranchById(id);
       if(branch1==null){
           throw new ApiExepstion("not found");
       }
       branchRebositry.delete(branch1);
   }


//   public void assignMerchentToBranch(Integer marchent_id,Integer branch_id){
//       Mearchent mearchent=merchentRebositry.findMearchentById(marchent_id);
//       Branch branch=branchRebositry.findBranchById(branch_id);
//       if(mearchent==null||branch==null){
//           throw new ApiExepstion("cannot assign ");
//       }
//       branch.setMearchent(mearchent);
//       branchRebositry.save(branch);
//
//   }
}
