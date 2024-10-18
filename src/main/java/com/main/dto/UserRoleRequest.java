package com.main.dto;

import java.util.Set;

import lombok.Data;

@Data
public class UserRoleRequest {

	private String roleName;
    private String roleDescription;
    private boolean canAccessMobileRequest;
    private boolean canAccessWebRequest;
    private int status;
    private Set<Long> permissionIds;
}
