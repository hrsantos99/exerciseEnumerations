package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDateTime moment;
	private String orderStatus;
	
	private client client;
	private List<orderItem> items = new ArrayList<>();
	
	public Order(LocalDateTime moment, String orderStatus, entities.client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	public List<orderItem> getItems() {
		return items;
	}

	public void addItem(orderItem item) {
		items.add(item);
	}
	
	public void removeItem(orderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (orderItem item : items) {
			sum += item.subTotal();	
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: " + orderStatus + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for(orderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		}
}
