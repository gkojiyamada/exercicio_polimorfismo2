package Application;

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

		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			switch (op) {
			case 'c':
				System.out.print("Name: ");
				sc.nextLine();
				String nameCommon = sc.nextLine();				
				System.out.print("Price: ");
				double priceCommon = sc.nextDouble();	
				Product prod = new Product(nameCommon, priceCommon);
				list.add(prod);
				break;
			case 'u':
				System.out.print("Name: ");
				sc.nextLine();
				String nameUsed = sc.nextLine();
				System.out.print("Price: ");
				double priceUsed = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product prodUsed = new UsedProduct(nameUsed, priceUsed, manufactureDate);
				list.add(prodUsed);
				break;
			case 'i':
				System.out.print("Name: ");
				sc.nextLine();
				String nameImported = sc.nextLine();
				System.out.print("Price: ");
				double priceImported = sc.nextDouble();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prodImported = new ImportedProduct(nameImported, priceImported, customsFee);
				list.add(prodImported);
				break;
			}
		}
		
		System.out.println();
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
