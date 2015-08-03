package ac.java.challenge.dao;


import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ac.java.challenge.model.Orders;

@Repository
public class OrderDAOImp implements OrderDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public OrderDAOImp() {
		
	}
	
	public OrderDAOImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Orders> list() {
		@SuppressWarnings("unchecked")
		List<Orders> listOrders = (List<Orders>) sessionFactory.getCurrentSession()
				.createCriteria(Orders.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listOrders;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Orders Orders) {
		sessionFactory.getCurrentSession().saveOrUpdate(Orders);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Orders OrdersToDelete = new Orders();
		OrdersToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(OrdersToDelete);
	}

	@Override
	@Transactional
	public Orders get(int id) {
		String sql = "from Orders where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Orders> listOrders = (List<Orders>) query.list();
		
		if (listOrders != null && !listOrders.isEmpty()) {
			return listOrders.get(0);
		}
		
		return (Orders) query.uniqueResult();
	}
}