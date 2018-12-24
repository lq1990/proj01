import java.util.ArrayList;
import java.util.List;

public class CustomerDao
{
	protected List<Customer> findCustomer() {
		// find db
		List<Customer> ret = new ArrayList<Customer> ();
		ret.add(new Customer("anna",23));
		ret.add(new Customer("beta",34));
		return ret;
	}
}
