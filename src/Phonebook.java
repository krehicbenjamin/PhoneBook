

import java.util.ArrayList;

public class Phonebook {
	private ArrayList<People> phonebook = new ArrayList<People>();
	
	public ArrayList<People> getPhoneBook(){
		return this.phonebook;
	}
	
	public void addPerson(People p) {
		this.phonebook.add(p);
	}
	
	public String getNameByNumber(String number) {
		String result = "Not found";
		for(People p : this.phonebook) {
			result = p.isThereTheNumber(number);
		}
		return result;
	}
	
	public ArrayList<String> getNumbers(String name) {
		ArrayList<String> numbers = new ArrayList<String>();
		for(People p : this.phonebook) {
			if(name.equals(p.getName())) {
				numbers = p.getPhoneNumbers();
			}
		}
		if(numbers.size() == 0) numbers.add("Not found");
		return numbers;
	}
	
	public void deleteInformation(String name) {
		for(People p : this.phonebook) {
			if(name.equals(p.getName())) {
				this.phonebook.remove(p);
				break;
			}
		}
	}
	
	public People getPersonalInformation(String name) {
		for(People p : this.phonebook) {
			if(name.equals(p.getName())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Person doesnt exist");
	}
	
	public void addNumber(String name, String number) {
		boolean personExists = false;
		for(People p : this.phonebook) {
			if(p.getName().equals(name)) {
				p.addPhoneNumber(number);
				personExists = true;
			}
		}
		if(!personExists) throw new IllegalArgumentException("Person doesn't exist");
	}
	public void setAddress(String name, String street, String city) {
		for(People p : this.phonebook) {
			if(p.getName().equals(name)) {
				p.addAddress(street, city);
			}
		}
	}
	
	public People keywordSearch(String keyword) {
		for(People p : this.phonebook) {
			if(p.getName().contains(keyword)) {
				return p;
			}if(p.getAddress() != null) {
				if(p.getAddress().getCity().contains(keyword) || p.getAddress().getStreet().contains(keyword)) {
					return p;
				}
			}
		}
		return null;
	}
	
	public void sort() {
		for(int i = 0; i < this.phonebook.size(); i++) {
			for(int j = 0; j < this.phonebook.size() - i - 1; j++) {
				if(phonebook.get(j).getName().compareTo(phonebook.get(j+1).getName()) > 0) {
					People temp = phonebook.get(j);
					phonebook.get(j).set(phonebook.get(j+1));
					phonebook.get(j+1).set(temp);
				}
			}
		}
	}
}
