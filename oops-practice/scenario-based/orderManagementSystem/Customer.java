package orderManagementSystem;

class Customer {
	private int customerId;
	private String customerName;

	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public String getCustomerName() {
		return customerName;
	}
}
