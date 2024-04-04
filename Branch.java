package com.example.onetoone.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String area;
    @ManyToOne
    @JoinColumn(name = "mearchent_id",referencedColumnName = "id")
    @JsonIgnore
    private Mearchent mearchent;
}
