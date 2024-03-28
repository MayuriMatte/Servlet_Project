package org.repo;

import java.util.ArrayList;
import java.util.List;

import org.Adminmodel.hotelinfomodel;
import org.Adminmodel.hotelmodel;

public class hotelRepository extends DBConfig{
	
	List<hotelmodel> list=new ArrayList<hotelmodel>();
	List<hotelinfomodel> hlist=new ArrayList<hotelinfomodel>();
	public boolean isAddHotel(hotelmodel model)
	{
		
		try
		{
			stmt=conn.prepareStatement("insert into hotel values('0',?)");
			stmt.setString(1, model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			return false;
		}
		
	}
	public List<hotelmodel> getAllHotels()
	{
		try
		{
			stmt=conn.prepareStatement("select *from hotel");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				hotelmodel model=new hotelmodel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list;
			
		}catch(Exception ex)
		{
			System.out.println("error is"+ex.toString());
			return null;
		}
	}
	public boolean isDeleteHotel(int hotelId)
	{
		try
		{
			stmt=conn.prepareStatement("delete from hotel where id=?");
			stmt.setInt(1, hotelId);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("error is"+ex);
			return false;
		}
		
	}
	public boolean isupdatehotel(hotelmodel hotel)
	{
		try
		{
			stmt=conn.prepareStatement("update hotel set name=? where id=?");
			stmt.setString(1,hotel.getName());
			stmt.setInt(2,hotel.getId());
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			
		}
		return false;	
	}
	public int gethotelid(String name)
	{
		try {
			stmt=conn.prepareStatement("select id from hotel where name=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			return 0;
		}
		
		
		
	}
	
	public boolean isAddhotelinfo(hotelinfomodel model)
	{
		try {
			int hotelid=this.gethotelid(model.getName());
			stmt=conn.prepareStatement("insert into hotelinfo values('0',?,?,?,?,?)");
			stmt.setString(1,model.getEmail());
			stmt.setString(2,model.getContact());
			stmt.setString(3,model.getLocation());
			stmt.setString(4,model.getAddress());
			stmt.setInt(5,hotelid);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	public List<hotelinfomodel> gethotelinfo()
	{
		try
		{
			stmt=conn.prepareStatement("select h.name,hi.email,hi.contact,hi.location,hi.address,hi.iid from hotel h inner join hotelinfo hi on h.id=hi.id");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				hotelinfomodel model=new hotelinfomodel();
				model.setName(rs.getString(1));
				model.setEmail(rs.getString(2));
				model.setContact(rs.getString(3));
				model.setLocation(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setInfoid(rs.getInt(6));
				this.hlist.add(model);
			}
			return hlist;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return null;
		
	}
	public boolean isDeletehotelinfo(int hotelinfoid)
	{
		try {
			stmt=conn.prepareStatement("Delete from hotelinfo where iid=?");
			stmt.setInt(1,hotelinfoid);
			int val=stmt.executeUpdate();
			return val>0?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}

	public boolean isupdatehotelinfo(hotelinfomodel model)
	{
		try {
			
			stmt=conn.prepareStatement("update hotelinfo set email=?,contact=?,location=?,address=? where iid=? ");
			stmt.setString(1,model.getEmail());
			stmt.setString(2,model.getContact());
			stmt.setString(3,model.getLocation());
			stmt.setString(4,model.getAddress());
			stmt.setInt(5,model.getInfoid());
			
			int val=stmt.executeUpdate();
			return val>0 ?true:false;
			
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
			
		}
		return false;
	}
}
