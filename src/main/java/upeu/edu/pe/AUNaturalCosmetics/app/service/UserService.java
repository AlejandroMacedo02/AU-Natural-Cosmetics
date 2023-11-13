/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.AUNaturalCosmetics.app.service;


import upeu.edu.pe.AUNaturalCosmetics.app.repository.UserRepository;
import upeu.edu.pe.AUNaturalCosmetics.infrastructure.entity.UserEntity;

/**
 *
 * @author alejandromacedop
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user){
        return userRepository.createUser(user);
    }
    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public UserEntity findById (Integer id){
        return userRepository.findById(id);
    }
}
