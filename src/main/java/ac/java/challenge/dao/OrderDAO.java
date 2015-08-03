package ac.java.challenge.dao;


import java.util.List;

import ac.java.challenge.model.*;

public interface OrderDAO {
	
	public List<Orders> list();
	public Orders get(int id);	
	public void saveOrUpdate(Orders o);	
	public void delete(int id);

}
