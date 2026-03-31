package orderManagementSystem;

class Card implements Payment {
	public void pay(double amount) throws PaymentFailedException {
		if(amount>50000) {
			throw new PaymentFailedException("Card Limit Exceeded");
		}
		else {
			System.out.println("Card Payment Successfully Done! "+amount);
		}
	}
}
