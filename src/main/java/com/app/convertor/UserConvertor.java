package com.app.convertor;

import com.app.entity.User;
import com.app.request.UserRequest;

public class UserConvertor {
    public static User userDtoToUser(UserRequest userRequest,String password){
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .emailId(userRequest.getEmailId())
                .roles(userRequest.getRoles())
                .password(password)
                .build();
        return user;
    }
}
