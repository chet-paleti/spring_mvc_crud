package crud;

import java.util.List;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public  Customer getCustomer(int myId) ;

	public void deleteCustomer(int myId);

}
