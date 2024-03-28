package org.repo;

import java.util.ArrayList;
import java.util.List;

import org.Adminmodel.citymodel;

public class cityrepository extends DBConfig{
 
	List<citymodel> citylist=new ArrayList<citymodel>();
	public boolean isAddCity(citymodel model)
	{
		try
		{
			stmt=conn.prepareStatement("insert into  city values('0',?)");
			stmt.setString(1,model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
		
	}
   public List<citymodel> getAllcity(){
	   try {
		   stmt=conn.prepareStatement("select *from city: ");
		   rs=stmt.executeQuery();
		   while(rs.next())
		   {
			   citymodel model=new citymodel();
			   model.setId(rs.getInt(1));
			   model.setName(rs.getString(2));
			   citylist.add(model);
			   
		   }
		   return citylist;
		   
	   }catch(Exception ex)
	   {
		   System.out.println("Error is"+ex);
	   }
	return null;
   }

	 
	}
