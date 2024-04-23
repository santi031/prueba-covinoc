package com.covinoc.prueba.controllers;

import com.covinoc.prueba.models.TypeUser;
import com.covinoc.prueba.services.TypeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/type-user")
public class TypeUserController {

    @Autowired
    private TypeUserService typeUserService;

    @GetMapping("/consult-type-users")
    public List<TypeUser> getTypeUsers() {
        return typeUserService.getAllTypeUsers();
    }

    @GetMapping("/consult-type-user/{typeUserId}")
    public Optional<TypeUser> getTypeUser(@PathVariable Long typeUserId) {
        return typeUserService.getTypeUserById(typeUserId);
    }

    @PostMapping("/create-type-user")
    public ResponseEntity<?> createTypeUser(@RequestBody TypeUser user) {
        return typeUserService.createTypeUser(user);
    }

    @PutMapping("/update-type-user/{typeUserId}")
    public ResponseEntity<?> updateTypeUser(@PathVariable Long typeUserId,@RequestBody TypeUser typeUser) {
        return typeUserService.updateTypeUser(typeUserId, typeUser);
    }

    @DeleteMapping("/delete-type-user/{typeUserId}")
    public ResponseEntity<?> deleteTypeUser(@PathVariable Long typeUserId) {
        return typeUserService.deleteTypeUser(typeUserId);
    }
}
