package com.main.dto;

import lombok.Data;

@Data
public class UserRolePremissionRequest {

	 private int moduleId;
	    private int subModuleIds;
	    private boolean canRead;
	    private boolean canWrite;
	    private boolean canUpdate;
	    private boolean canDelete;
	    private boolean isDefaultLandingPage;
	    private Long roleId;
}
