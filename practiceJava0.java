class Cat{
	String color;
	String name;

	public Cat (String color, String name){
		this.color = color;
		this.name = name;
	}

	public static void main (String args[]){
		Cat c1 = new Cat("orange", "Jim");
		System.out.println(c1);
		Collection cSet = new HashSet<Cat>();
		cSet.add(c1);
		System.out.println(cSet);

	}

	public String toString(){
		return color + name;
	}
}