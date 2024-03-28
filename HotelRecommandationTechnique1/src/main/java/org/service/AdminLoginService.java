package org.service;

import org.Adminmodel.loginmodel;
import org.repo.AdminLoginRepository;

public class AdminLoginService  {
    AdminLoginRepository adRepo=new  AdminLoginRepository();
    
	public boolean isAdminLogin(loginmodel m1)
	{
		
		
		return adRepo.isAdminLogin(m1);
	}

	
	}

