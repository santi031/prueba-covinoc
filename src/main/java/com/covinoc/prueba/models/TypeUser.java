package com.covinoc.prueba.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type_users")
public class TypeUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_users")
    private Long id;

    @Column(name = "name")
    private String name;
}
