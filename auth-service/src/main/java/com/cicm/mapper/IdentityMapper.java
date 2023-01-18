package com.cicm.mapper;

import com.cicm.dto.UserDTO;
import com.cicm.model.Identity;
import jakarta.inject.Singleton;
import org.mindrot.jbcrypt.BCrypt;

@Singleton
public class IdentityMapper {

    public UserDTO toDTO(Identity identity) {
        return new UserDTO(
                identity.getFullName(),
                identity.getUsername(),
                identity.getEmail(),
                null,
                identity.getDateOfBirth(),
                identity.getRole()
        );
    }
    public Identity toEntity(UserDTO userDTO) {
        return new Identity(
                userDTO.username(),
                userDTO.fullName(),
                userDTO.email(),
                BCrypt.hashpw(userDTO.password(), BCrypt.gensalt()),
                userDTO.dateOfBirth(),
                userDTO.role()
        );
    }
}
