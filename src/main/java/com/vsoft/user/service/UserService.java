package com.vsoft.user.service;

import com.vsoft.user.entity.UserEntity;
import com.vsoft.user.model.User;
import com.vsoft.user.repository.UserRepository;
import com.vsoft.user.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommonUtil commonUtil;

    public User getUser(Integer id){
       UserEntity userObj =  userRepository.findById(id).get();
       if(userObj == null){
           throw new RuntimeException("Requested user does not found.");
       }
       User user = (User) commonUtil.convertToObject(userObj, User.class);
       return user;
    }

    public List<User> getAllUsers() {
        List<UserEntity> usersList = userRepository.findAll();
        List<User> users = (List) commonUtil.convertToList(usersList, User.class);
        return users;
    }

    public User saveUser(User user){
        UserEntity userEntity = (UserEntity) commonUtil.convertToObject(user, UserEntity.class);
        UserEntity respEntity = userRepository.save(userEntity);
        return (User) commonUtil.convertToObject(respEntity, User.class);
    }

    public User updateUser(Integer id, User user){
        UserEntity entity = userRepository.findById(id).get();
        if(entity == null){
            throw new RuntimeException("User not exist");
        }
        UserEntity newEntity = (UserEntity) commonUtil.convertToObject(user, UserEntity.class);
        newEntity.setId(id);
        UserEntity updatedEntity = userRepository.save(newEntity);
        return (User) commonUtil.convertToObject(updatedEntity, User.class);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
