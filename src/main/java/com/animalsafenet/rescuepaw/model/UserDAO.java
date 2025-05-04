package com.animalsafenet.rescuepaw.model;

import com.animalsafenet.rescuepaw.repository.entity.Role;
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
    private Role role;


}
