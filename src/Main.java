import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Phonebook phoneBook = new Phonebook();
		
		People first = new People("first");
		
		first.addAddress("houafufa", "af3uhau3f");
		first.addPhoneNumber("3298473284");
		first.addPhoneNumber("324321");
		phoneBook.addPerson(first);
		
		People second = new People("second");
		
		second.addAddress("nafafee", "aefeflke");
		second.addPhoneNumber("839274983");
		second.addPhoneNumber("3829473289");
		phoneBook.addPerson(second);
		
		People third = new People("third");
		
		third.addPhoneNumber("342432423");
		third.addPhoneNumber("12412432");
		phoneBook.addPerson(third);
		
		People fourth = new People("fourth");
		
		fourth.addAddress("feafaef", "dgsdgs");
		phoneBook.addPerson(fourth);
		
		
		System.out.println("Phone search" + '\n' + "available operations: "+ '\n' + "#1 add number" + '\n' + "#2 search for a number" 
		+ '\n' + "#3 search for a person by phone number" + '\n' + "#4 add an address" + '\n' + "#5 search for personal information" 
		+ '\n' + "#6 delete personal information" + '\n' + "#7 filtered listing" + '\n' + "x quit");
		
		
		
		
		
		String Imput;
		Scanner reader = new Scanner(System.in);
		Imput = reader.nextLine();
		for(;;){
		
			
			if(Integer.parseInt(Imput) == 1) {
				
				System.out.println("Whose number: ");
				String name = reader.nextLine();
				System.out.println("Number: ");
				String number = reader.nextLine();
				
				try {
					
					phoneBook.addNumber(name, number);
				
				}catch(Exception e) {
					
					System.out.println(e.getMessage());
					
				}
			}else if(Integer.parseInt(Imput) == 2) {
				
				System.out.println("Whose number: ");
				String name = reader.nextLine();
				ArrayList<String> numbers = phoneBook.getNumbers(name);
				
				for(String number : numbers) {
					System.out.println(number);
				}
			
			}else if(Integer.parseInt(Imput) == 3) {
				
				System.out.println("Number: ");
				String number = reader.nextLine();
				String name = phoneBook.getNameByNumber(number);
				System.out.println(name);
			
			}else if(Integer.parseInt(Imput) == 4) {
				
				System.out.println("Whose address: ");
				String name = reader.nextLine();
				System.out.println("Street: ");
				String street = reader.nextLine();
				System.out.println("City: ");
				String city = reader.nextLine();
				phoneBook.setAddress(name, street, city);
			
			}else if(Integer.parseInt(Imput) == 5) {
				
				System.out.println("Whose information: ");
				String name = reader.nextLine();
				
				try {
					People p = phoneBook.getPersonalInformation(name);
					String city = p.getAddress().getCity();
					String street = p.getAddress().getStreet();
					ArrayList<String> numbers = p.getPhoneNumbers();
					System.out.println("Address: " + street + " " + city);
					if(numbers.size() == 0) System.out.println("Phone number not found");
					
					else {
						System.out.println("Phone numbers: ");
						for(String n : numbers) {
							System.out.println(n);
						}
					}
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}else if(Integer.parseInt(Imput) == 6) {
				
				System.out.println("Whose information: ");
				String name = reader.nextLine();
				phoneBook.deleteInformation(name);
				
			}else if(Integer.parseInt(Imput) == 7) {
				
				System.out.println("Keyword (if empty, all listed): ");
				String keyword = reader.nextLine();
				People p = phoneBook.keywordSearch(keyword);
				if(p == null) {
					phoneBook.sort();
					for(People a : phoneBook.getPhoneBook()) {
						String name = a.getName();
						System.out.println(name);
						if(a.getAddress() != null) {
						String city = a.getAddress().getCity();
						String street = a.getAddress().getStreet();
						System.out.println("Address: " + street + " " + city);
						}else {
							System.out.println("Address not found");
						}
						ArrayList<String> numbers = a.getPhoneNumbers();
						System.out.println(name + ": ");
						
						if(numbers.size() == 0) System.out.println("Phone number not found!");
						else {
							System.out.println("Phone numbers: ");
							for(String n : numbers) {
								System.out.println(n);
							}
						}
					}
				}else if(Imput.equals("x")){
				
					break;
				
				}else {
					String name = p.getName();
					String city = p.getAddress().getCity();
					String street = p.getAddress().getStreet();
					ArrayList<String> numbers = p.getPhoneNumbers();
					System.out.println(name + ": ");
					System.out.println("Address: " + street + " " + city);
					
					if(numbers.size() == 0) System.out.println("Phone number not found!");
					else {
						System.out.println("Phone numbers: ");
						for(String n : numbers) {
							System.out.println(n);
						}
					}
					
				} 
			}else {
				System.out.println("Invalid input");
			}
			Imput = reader.nextLine();
		}
		
		
		
		reader.close();
	}

}
