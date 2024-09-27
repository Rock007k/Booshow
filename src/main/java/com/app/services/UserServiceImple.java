package com.app.services;

import com.app.convertor.UserConvertor;
import com.app.entity.User;
import com.app.exceptions.UserExist;
import com.app.repository.UserRepository;
import com.app.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImple implements UserServices{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findByEmailId(userRequest.getEmailId());

        if(user.isPresent()){
            throw new UserExist();
        }

        User _user = UserConvertor.userDtoToUser(userRequest,"12345678");
        userRepository.save(_user);
        return "User Saved Successfully";
    }
}
