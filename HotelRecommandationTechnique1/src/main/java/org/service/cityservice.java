package org.service;
import java.util.*;

import org.Adminmodel.citymodel;
import org.repo.cityrepository;
public class cityservice {
     cityrepository cityrepo=new cityrepository();
	public boolean isAddcity(citymodel model)
	{
		return cityrepo.isAddCity(model);
		
	}
	public List<citymodel> getAllcity() {
		return cityrepo.getAllcity();
	}
}
