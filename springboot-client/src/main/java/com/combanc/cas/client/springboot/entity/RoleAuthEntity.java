package com.combanc.cas.client.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleAuthEntity extends BaseDto<RoleAuthEntity> {

    private Long roleId;
    private String roleAuth;
    private String secretKey;

}
