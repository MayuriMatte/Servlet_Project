package org.repo;

import org.Adminmodel.loginmodel;

public class AdminLoginRepository extends DBConfig{

	public boolean isAdminLogin(loginmodel model)
	{
		System.out.println(model);
		try
		{
			stmt=conn.prepareStatement("select * from AdminLogin where username=? and password=?");
			stmt.setString(1,model.getUsername());
			stmt.setString(2,model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				System.out.println("t");
				return true;
					
			}
			else
			{
				System.out.println("f");
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println("error is"+ex);
		}
		return false;
		
	}
}
