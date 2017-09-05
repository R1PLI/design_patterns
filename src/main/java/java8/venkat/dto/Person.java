package java8.venkat.dto;

public class Person {
	int age;
	String name;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person with " +
			"age = " + age +
			", name = '" + name + '\'';
	}
}
