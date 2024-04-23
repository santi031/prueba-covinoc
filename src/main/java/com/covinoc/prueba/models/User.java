package com.covinoc.prueba.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    private Long phone;

    @ManyToOne
    @JoinColumn(name = "id_type_user")
    private TypeUser typeUser;

    @Column(name = "identification")
    private Long identification;
}
