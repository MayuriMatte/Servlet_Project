package org.service;

import java.util.List;
import java.util.*;

import org.Adminmodel.hotelinfomodel;
import org.Adminmodel.hotelmodel;
import org.repo.hotelRepository;

public class hotelservice {

     hotelRepository hotelrepo=new hotelRepository();
	public boolean isAddHotel(hotelmodel model)
	{
		return hotelrepo.isAddHotel(model);
		
	}
	public  List<hotelmodel> getAllHotels() {
		
		return hotelrepo.getAllHotels();
	}
	public boolean isDeleteHotel(int hotelid)
	{
		return hotelrepo.isDeleteHotel(hotelid);
		
	}
	public boolean isupdatehotel(hotelmodel Model)
	{
		return hotelrepo.isupdatehotel(Model);
		
	}
	public boolean isAddhotelinfo(hotelinfomodel model)
	{
		return hotelrepo.isAddhotelinfo(model);
		
	}
     public List<hotelinfomodel> gethotelList()
     {
		return hotelrepo.gethotelinfo();
    	 
     }
     public boolean isDeletehotelinfo(int hotelid)
     {
		return hotelrepo.isDeletehotelinfo(hotelid);
    	 
     }
     public boolean isupdateinfohotel(hotelinfomodel model)
     {
		return hotelrepo.isupdatehotelinfo(model);
    	 
     }
	
}
