public class Cat1{
	public Cat1 (String name){
		this.name = name;
	}

	public static void main (String args[]){
		Collection<Cat1> cat1List = new HashSet<Cat1>();
		cat1List.add(new Cat1("Fido"));
		cat1List.add(new Cat1("Phideaux"));
		cat1List.add(new Cat1("Fido"));
	}

	public static string toString(){
		return name;
	}
}

public class Cat2{

}