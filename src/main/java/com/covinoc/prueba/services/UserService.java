package com.covinoc.prueba.services;

import com.covinoc.prueba.exceptions.GlobalExceptionHandler;
import com.covinoc.prueba.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.covinoc.prueba.models.User;
import com.covinoc.prueba.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    private final Utils utils = new Utils();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByIdentification(Long identification) {
        return userRepository.findByIdentification(identification);
    }

    public ResponseEntity<?> createUser(User user) {
        Optional<User> res = userRepository.findByIdentification(user.getIdentification());
        if (res.isPresent()) {
            throw new GlobalExceptionHandler("409",HttpStatus.INTERNAL_SERVER_ERROR, "Ya existe un usuario con ese identification");
        }
        userRepository.save(user);
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.CREATED, user, "Usuario registrado con exito"),
                HttpStatus.OK
        );
    }

    public ResponseEntity<?> updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findByIdentification(userId);
        User user = new User();
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.setName(userDetails.getName());
            user.setLastname(userDetails.getLastname());
            user.setPhone(userDetails.getPhone());
            user.setTypeUser(userDetails.getTypeUser());
            user.setIdentification(userDetails.getIdentification());
        } else {
            throw new GlobalExceptionHandler("500",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "No existe un usuario con esa identification");
        }

        userRepository.save(user);
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.CREATED, user, "Usuario actualizado con exito"),
                HttpStatus.OK
        );
    }

    public ResponseEntity<?> deleteUser(Long userId) {
        Optional<User> res = userRepository.findByIdentification(userId);
        if (res.isPresent()) {
            userRepository.deleteById(res.get().getId());
        } else {
            throw new GlobalExceptionHandler("500",HttpStatus.INTERNAL_SERVER_ERROR, "No existe un usuario con esa identification");
        }
        return new ResponseEntity<>(
                utils.manageResponse(HttpStatus.OK, res.get().getIdentification(), "Usuario eliminado con exito"),
                HttpStatus.OK
        );
    }
}
