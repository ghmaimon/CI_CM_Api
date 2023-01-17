package com.cicm.service;

import com.cicm.dto.UserDTO;
import com.cicm.mapper.IdentityMapper;
import com.cicm.model.Identity;
import com.cicm.repository.IdentityRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@Singleton
@RequiredArgsConstructor
public class IdentityService {

    private final IdentityRepository identityRepository;
    private final IdentityMapper identityMapper;


    public Boolean validateCredentials(String username, String password) {
        Identity identity = this.getIdentityByUsername(username);
        return BCrypt.checkpw(password, identity.getPassword());
    }

    private Identity getIdentityByUsername(String username) {
        return identityRepository.findByUsername(username).orElseThrow(
                () -> new IllegalStateException("user not found")
        );
    }


    public void signUp(UserDTO userDTO) {
        Identity identity = identityMapper.toEntity(userDTO);
        identityRepository.save(identity);
    }
}
