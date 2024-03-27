package crud;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session thesession = sessionFactory.getCurrentSession();
		
		Query<Customer> myquery = thesession.createQuery("from Customer", Customer.class); 
		List<Customer> customers =new ArrayList<>();
		
		customers = myquery.getResultList(); 
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
	
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int myId) {
	
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, myId);
		return customer;
	}

	@Override
	public void deleteCustomer(int myId) {
		Session session = sessionFactory.getCurrentSession();
		/*Customer tmpcust = session.get(Customer.class, myId);
		session.delete(tmpcust);*/
		Query delete_query = session.createQuery("delete from Customer where id=:custid");
		delete_query.setParameter("custid", myId);
		delete_query.executeUpdate();	
		
	}

}
