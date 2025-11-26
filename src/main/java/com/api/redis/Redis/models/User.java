package com.api.redis.Redis.models;


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String userId;
    private String name;
    private String phone;
    private String email;

}
