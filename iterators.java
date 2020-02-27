import java.util.*;

public class Dog{
	String name;

	public Dog(String name){
		this.name = name;
	}

	public static void main(String args[]){
		Dog d1 = new Dog("Fido");
		Dog d2 = new Dog("Spot");
		Dog d3 = new Dog("Lucy");

		Collection dogCol = new Set<Dog>();
		dogCol.add(d1); dogCol.add(d2); dogCol.add(d3);

		System.out.println(dogCol);

		for(Dog dog : dogCol){
			if(dog.name == "Spot"){
				System.out.println(dog);
			}
		}

		//needs an iterator
	}

	public String toString(){
		return name;
	}
}