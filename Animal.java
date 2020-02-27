import java.util.*;

public class Animal implements Comparable{
	int legs;
	String name;
}

public class Dog extends Animal{
	public String toString(){
		return this.name + " with " + this.legs + " legs";
	}

	public static void main(String args[]){
		ArrayList<Dog> pack = new ArrayList<Dog>();
		pack.add(new Dog(4, "Joey"));
		pack.add(new Dog(3, "Joey"));
		pack.add(new Dog(4, "Spot"));

		System.out.println(pack);

		Collections.sort(pack);
		System.out.println(pack);

		Collections.sort(pack, new AnimalCompre());
		System.out.println(pack);
	}
}

class AnimalCompare implements Comparator<Animal>{
	public int compareTo(Animal a1, Animal a2){
		int nameComp = a1.name.compareTo(a2.name);

		if(nameComp == 0){
			return a1.legs - a2.legs;
		}
		else{
			return nameComp;
		}
	}
}