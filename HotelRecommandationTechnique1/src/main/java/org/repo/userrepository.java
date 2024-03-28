package org.repo;

import org.Adminmodel.Registermodel;
import org.Adminmodel.loginmodel;

public class userrepository extends DBConfig{

	public boolean isRegisterUser(Registermodel model)
	{
		try
		{
		
			stmt=conn.prepareStatement("insert into userreg values('0',?,?,?,?,?)");
			stmt.setString(1,model.getName());
			stmt.setString(2,model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4,model.getUsername());
			stmt.setString(5,model.getPassword());
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return false;
		}
		
		
	}
	public int validateuser(loginmodel model)
	{
		try {
			stmt=conn.prepareStatement("select *from userreg where username=? and password=?");
			stmt.setString(1,model.getUsername());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return -1;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return -1;
	}
}
