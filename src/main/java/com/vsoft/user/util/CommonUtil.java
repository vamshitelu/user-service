package com.vsoft.user.util;

import com.vsoft.user.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Configuration
public class CommonUtil {

    @Autowired
    private ModelMapper modelMapper;

    public Object convertToObject(Object entity, Class<?> destination){
        return modelMapper.map(entity, destination);
    }

    public List<?> convertToList(List<UserEntity> entities, Class<?> destination){
        return entities.stream().map(e -> modelMapper.map(e, destination))
                        .collect(Collectors.toList());
    }
}
