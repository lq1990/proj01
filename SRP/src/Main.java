
public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("this is main method.");
		CustomerChart customerChart = new CustomerChart();
		customerChart.setDao(new CustomerDao());
		customerChart.displayChart();
		
	}

}
