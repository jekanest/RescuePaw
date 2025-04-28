package com.animalsafenet.rescuepaw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {

    private Long id;
    private String email;
    private String name;
    private String role;


}
