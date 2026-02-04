package practice.json;

public class Car {
	public String brand;
	public int price;


	public Car(String brand, int price) {
	this.brand = brand;
	this.price = price;
	}
	
	public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}