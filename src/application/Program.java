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
		
		List<Product> prod = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int numb = sc.nextInt();
		
		for (int i = 1; i <= numb; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Type of the product (common, used or imported (c/u/i)): ");
			char typeProduct = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
	        if (typeProduct == 'c' || typeProduct == 'C') {
	        	prod.add(new Product(name, price));
	        }
			
	        else if (typeProduct == 'i' || typeProduct == 'I') {
				System.out.print("Customs Fee: ");
				double customFee = sc.nextDouble();
				prod.add(new ImportedProduct(name, price, customFee));
			}
			else if (typeProduct == 'u' || typeProduct == 'U') {
				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());
				prod.add(new UsedProduct(name, price, manufactureDate));
			}
			
		}
			
		System.out.println();
		
		System.out.println("PRICE TAGS: ");	
		
		for (Product p : prod) {
			System.out.println(p.priceTag());
		}
				
		sc.close();

	}

}
