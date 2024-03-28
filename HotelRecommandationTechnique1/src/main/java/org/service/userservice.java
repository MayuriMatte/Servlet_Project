package org.service;

import org.Adminmodel.Registermodel;
import org.Adminmodel.loginmodel;
import org.repo.userrepository;

public class userservice {
    userrepository userRepo=new userrepository();
	public boolean isRegisterUser(Registermodel model)
	{
		return userRepo.isRegisterUser(model);
		
	}
	public int validateUser(loginmodel model)
	{
		return userRepo.validateuser(model);
		
	}
}
