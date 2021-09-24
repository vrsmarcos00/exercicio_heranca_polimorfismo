package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		System.out.println();
		
		for(int i=1; i<=N; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c, u, i)? ");
			char ch = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				System.out.println();
				
				Product product = new ImportedProduct(name, price, customFee);
				products.add(product);
			}
			
			else if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				System.out.println();
				
				Product product = new UsedProduct(name, price, date);
				products.add(product);
			}
			
			else if(ch == 'c') {
				System.out.println();
				Product product = new Product(name, price);
				products.add(product);
			}
		}
		
		System.out.println("PRICE TAGS: ");
		for(Product p : products) {
			System.out.println(p.priceTag());
		}
		
		sc.close();

	}

}
