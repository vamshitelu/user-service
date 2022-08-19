package com.vsoft.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;

}
