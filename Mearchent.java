package com.example.onetoone.Model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Mearchent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "mearchent")
    private Set<Branch> branchSet;  //set prevent duplcited
}
