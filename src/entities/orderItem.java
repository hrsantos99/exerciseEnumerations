package entities;

public class orderItem {

	private Integer quantity;
	private Double price;
	
	private product product;
	
	public orderItem(Integer quantity, Double price, entities.product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public product getProduct() {
		return product;
	}

	public void setProduct(product product) {
		this.product = product;
	}

	public Double subTotal() {
		return price*quantity;
	}
	
	public String toString() {
		return product.getName()
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: "
				+ String.format("%.2f", subTotal());
	}
}
