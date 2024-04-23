package com.covinoc.prueba.services;

import com.covinoc.prueba.exceptions.GlobalExceptionHandler;
import com.covinoc.prueba.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.covinoc.prueba.models.TypeUser;
import com.covinoc.prueba.repositories.TypeUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeUserService {

	@Autowired
    private TypeUserRepository typeUserRepository;

    private final Utils utils = new Utils();

    public List<TypeUser> getAllTypeUsers() {
        return typeUserRepository.findAll();
    }

    public Optional<TypeUser> getTypeUserById(Long typeUserId) {
        return typeUserRepository.findById(typeUserId);
    }

    public ResponseEntity<?> createTypeUser(TypeUser typeUser) {
        Optional<TypeUser> res = typeUserRepository.findById(typeUser.getId());
        if (res.isPresent() && res.get().getName().equals(typeUser.getName())) {
            throw new GlobalExceptionHandler("409",HttpStatus.INTERNAL_SERVER_ERROR, "Ya existe un tipo de usuario con ese nombre");
        }
        typeUserRepository.save(typeUser);
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.CREATED, typeUser, "Tipo de usuario registrado con exito"),
                HttpStatus.OK
        );
    }

    public ResponseEntity<?> updateTypeUser(Long typeUserId, TypeUser typeUserDetails) {
        Optional<TypeUser> typeUserOptional = typeUserRepository.findById(typeUserId);
        TypeUser typeUser = new TypeUser();
        if (typeUserOptional.isPresent()) {
            typeUser = typeUserOptional.get();
            typeUser.setName(typeUserDetails.getName());
        } else {
            throw new GlobalExceptionHandler("500",HttpStatus.INTERNAL_SERVER_ERROR, "No existe un tipo de usuario con ese nombre");
        }
        typeUserRepository.save(typeUser);
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.CREATED, typeUser, "Tipo de usuario actualizado con exito"),
                HttpStatus.OK
        );
    }

    public ResponseEntity<?> deleteTypeUser(Long typeUserId) {
        Optional<TypeUser> res = typeUserRepository.findById(typeUserId);
        if (res.isPresent()) {
            typeUserRepository.deleteById(res.get().getId());
        } else {
            throw new GlobalExceptionHandler("500", HttpStatus.INTERNAL_SERVER_ERROR, "No existe este tipo de usuario");
        }
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.OK, res.get().getName(), "Tipo de usuario eliminado con exito"),
                HttpStatus.OK
        );
    }
}
