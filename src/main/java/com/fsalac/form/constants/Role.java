package com.fsalac.form.constants;

public enum Role {
	
	ROLE_ADMIN(0, "ROLE_ADMIN"),
    ROLE_USER(1, "ROLE_USER");
    
    private Integer id;
    private String name;
    
    Role(Integer id, String name){
    	this.setId(id);
    	this.setName(name);
    }

    public static Role getType(Integer id) {
		
    	Role[] values = Role.values();
		
		for (Role userRole : values) {
			if(userRole.getId().equals(id)){
				return userRole;
			}
		}
		
		System.out.println("AccountType cannot be found");
		return null;
			
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}