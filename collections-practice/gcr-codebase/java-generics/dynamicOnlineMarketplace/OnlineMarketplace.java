package dynamicOnlineMarketplace;

public class OnlineMarketplace {

	public static void main(String[] args) {

		Product<BookCategory> book = new Product<>("Java Programming", 500, new BookCategory());

		Product<ClothingCategory> shirt = new Product<>("T-Shirt", 800, new ClothingCategory());

		ProductCatalog catalog = new ProductCatalog();

		catalog.addProduct(book);
		catalog.addProduct(shirt);

		DiscountUtil.applyDiscount(book, 10);
		DiscountUtil.applyDiscount(shirt, 5);

		catalog.displayProducts();
	}
}
