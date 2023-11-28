package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Order;
import entities.client;
import entities.orderItem;
import entities.product;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine(), sdf);
		
		client c1 = new client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Order o1 = new Order(LocalDateTime.now(), status, c1);
		
		System.out.print("How many items to this order? ");
		Integer n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			product p = new product(productName, price);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			orderItem orderItem = new orderItem(quantity, price, p);
			
			o1.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(o1);

		sc.close();
	}

}
