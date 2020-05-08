/*

learning how to define and use a class

*/



/*
//继承
//构造方法 + 私有方法 不能继承 / 私有成员变量可以被继承，但不能直接访问
//construct时，夫类的default constructor永远都会被调用
//一个孩子一个爹，一个爹可以有多个孩子
//访问权限不能变小，可以相同或者变大
//方法重写时，方法名要相同，参数列表相同以及返回值类型相同，可以返回子类类型

public class Test{

	public static void main(String arg[]){
		Worker w1 = new Worker();
		w1.print(); //null 0 call the print function in class person
		
		Worker w2 = new Worker(18, "pack", 1201);
		//w2.play("snake");
		//w2.eat("pizza");
		w2.print();
		
		//Teacher t1 = new Teacher();
		//t1.print(); //null 0
	}

}


public class Person{
	
	//member declaration
	private String name;
	private int age;


	//constructor declaration
	public Person(){
		System.out.println("person default constructor");
	}

	public Person(int age, String name){
		System.out.println("person constructor");
		setName(name);
		setAge(age);
	}


	//accesing functions
	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setAge(int age){
		if(age > 0 && age < 150)	this.age = age;
		else				System.out.println("not valid age");
	}


	//other member functions
	public void print(){
		System.out.println("person print name = " + getName() + " + age = " + getAge());
	}
	
	public void eat(String food){
		System.out.println(food + " yummy!");
	}

	public void play(String game){
		System.out.println(game + " funny!");
	}

	
}


public class Worker extends Person{

	private int salary;
	
	public 	Worker(){
		//super();	调用父类的default constructor 可以省略
		System.out.println("worker default constructor");
	}
	
	public 	Worker(int age, String name, int salary){
		super(age, name);	//setAge(age); setName(name);
		System.out.println("worker constructor");
		setSalary(salary);
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setSalary(int salary){
		if(salary > 1200) 	this.salary = salary;
		else 			System.out.println("not valid salary");
	}

	@Override	//注释，用于说明下面是重写，如果没有重写成功会报错
	public void print(){
		super.print();	//调用父类的print方法
		System.out.println("worker print name = " + getName() + " + age = " + getAge() + " + salary = " + getSalary());
	}
	
}


public class Teacher extends Person{





}


*/



































/*

//Singleton 单例设计模式 / 懒汉式

public class Singleton{
	
	//add private to avoid assigning it to null
	private static Singleton sin = null; 

	//object
	private Singleton(){
	}

	public static Singleton getInstance(){
		if(sin == null)		sin = new Singleton();
		return sin;
	}

	public static void main(String[] args){
		Singleton s1 = new Singleton();
		Singleton s2 = new Singleton();
		System.out.println(s1==s2); //false


		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		System.out.println(s3==s4); //ture

	}

}

*/






















/*

//Singleton 单例设计模式 / 饿汉式 / 更推荐

public class Singleton{
	
	//add private to avoid assigning it to null
	private static Singleton sin = new Singleton(); 

	//object
	private Singleton(){
	}

	public static Singleton getInstance(){
		return sin;
	}

	public static void main(String[] args){
		Singleton s1 = new Singleton();
		Singleton s2 = new Singleton();
		System.out.println(s1==s2); //false


		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		System.out.println(s3==s4); //ture

	}

}

*/
























/*

public class MainTest{
	
	public static void main(String[] args){
		System.out.println("input length = " + args.length);
		System.out.println("print all:");

		for(int cnt = 0; cnt < args.length; cnt++){
			System.out.println(cnt + args[cnt]);
		}


	}

	//in terminal javac MainTest.java	
	//in terminal java MainTest haha hoho hehe

}

*/


























/*
//initialization block

public class Block{

	//在constructor之前需要做的一些事情可以写在这个大括号中，在constructor之前运行
	//比如，对成员变量进行的统一初始化操作
	{
		System.out.println("构造块");
	}


	//静态代码块,最先运行，但只执行一次
	//比如，加载数据库的驱动包
	static{
		System.out.println("静态代码块");

	}



	public Block(){
		System.out.println("构造方法体");
	}

	public static void main(String[] args){
	
		Block b = new Block();
		Block b2 = new Block();

		
	}



}

*/


























/*

public class StaticTest{

	private int cnt = 1;
	private static int snt = 2;

	//自定义静态成员方法，用类名.的方式使用
	public static void show(){
		//System.out.println("cnt = " + cnt);
		System.out.println("snt = " + snt);
	}

	public static void main(String[] args){
	
		StaticTest s = new StaticTest();
		s.show();

		
		StaticTest.show();
	}


	
	//public static void setSnt(int snt){ 
	//	//cannot have this
	//	StaticTest.snt = snt;
	//}
	
}

*/























/*

//static 概念

import java.util.Scanner;

public class StudentTest{
	public static void main(String[] args){
		
		//static
		
		Student s1 = new Student(1001, "p1");
		s1.country = "CHINA";
		s1.show();
		
		Student s2 = new Student(1002, "p2");
		s2.show();


		System.out.println("please enter the total number of students");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();

		Student arr[] = new Student[num];

		for(int cnt = 0; cnt < num; cnt++){
			System.out.println("please enter the id and name for the " + (cnt+1) + "th student");
			
			Student temp = new Student();
			temp.setId(sc.nextInt());
			temp.setName(sc.next());
			arr[cnt] = temp;
		}

		for(int cnt =0; cnt<num; cnt++){
			arr[cnt].show();
		}

	}
}

public class Student{
	
	private int id;
	private String name;
	public static String country;

	public Student(){
	}
	
	public Student(int id, String name){
		setId(id);
		setName(name);
	}

	public void show(){
		System.out.println("my name is: " + name + " + my id is: " + id);
		System.out.println("my country is: " + country);
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
		
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(int id){
		if(id >= 0)
			this.id = id;
		else
			System.out.println("input id < 0");
	}
}

*/





























/*
import java.util.Scanner;

public class StudentTest{
	public static void main(String[] args){
		System.out.println("please enter the total number of students");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();

		Student arr[] = new Student[num];

		for(int cnt = 0; cnt < num; cnt++){
			System.out.println("please enter the id and name for the " + (cnt+1) + "th student");
			
			Student temp = new Student();
			temp.setId(sc.nextInt());
			temp.setName(sc.next());
			arr[cnt] = temp;
		}

		for(int cnt =0; cnt<num; cnt++){
			arr[cnt].show();
		}

	}
}

public class Student{
	
	private int id;
	private String name;

	public Student(){
	}
	
	public Student(int id, String name){
		setId(id);
		setName(name);
	}

	public void show(){
		System.out.println("my name is: " + name + " + my id is: " + id);
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
		
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(int id){
		if(id >= 0)
			this.id = id;
		else
			System.out.println("input id < 0");
	}
}

*/



























/*

//private member

public class StudentTest{
	public static void main(String[] args){
		Student s = new Student();
		s.show();

		s.setName("pckk");
		s.setId(-1);
		s.show();

		Student s2 = new Student(-1, "ja");
		s2.show();
	}
}

public class Student{
	
	private int id;
	private String name;

	public Student(){
	}
	
	public Student(int id, String name){
		setId(id);
		setName(name);
	}

	public void show(){
		System.out.println("my name is: " + name + " + my id is: " + id);
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
		
	public void setName(String name){
		this.name = name;
	}
	
	public void setId(int id){
		if(id >= 0)
			this.id = id;
		else
			System.out.println("input id < 0");
	}
}

*/
























/*

//separate the functional class and main
public class FeeTest{
	public static void main(String[] args){
		Fee f = new Fee();
		int res = f.calculate(7);
		System.out.println("result = " + res);

		Fee f2 = new Fee();
		int res2 = f.fast_cal(7);
		System.out.println("result = " + res2);
	}
}

public class Fee{

	//recursion递归
	int calculate(int n){
		if(n == 1 || n == 2)	return 1;
		else		return calculate(n-2) + calculate(n-1);
	}

	//递推
	int fast_cal(int n){
		int first = 1;
		int second = 1;
		
		for(int cnt = 3; cnt <= n; cnt++){
			int sum = first + second;
			first = second;
			second = sum;
		}
		
		return second;
	}

}

*/


























/*
public class Factorial{

	//normal way
	int show(int n){
		int result = 1;
		for(int count = 1; count <= n; count++){
			result *= count;
		}
		return result;
	}

	//recursion
	int calculate(int n){
		if(n == 1)	return 1;
		else		return n*calculate(n-1);
	}

	public static void main(String[] args){
		Factorial f = new Factorial();
		int res = f.show(5);
		System.out.println("result = " + res);
			

		int res2 = f.calculate(5);
		System.out.println("result = " + res2);


	}

}
*/


























/*
public class Boy{

	String name;

	Boy(){
		//调用本类中的有构造方法，必须要写在第一行
		//this("no name");
	}
	
	Boy(String name){
		//先创一个default再赋值
		//this();

		this.name = name;
	}

	void show(){
		System.out.println("my name is = " + name);
	}
	
	public static void main(String[] args){
		Boy b1 = new Boy();
		b1.show();
		
		Boy b2 = new Boy("pack");
		b2.show();

		//只是在stack里面给一个指向null pointer的地方，找不到heap中对应的name
		Boy b3 = null;
		//b3.show(); error
	}

}
*/
 

























/*
public class ThisTest{
	int a;
	
	ThisTest(){
		// this is referring to the thing that is constructing now
		System.out.println("in constructor =" + this);
	}

	void show(){
		// this is referring to the thing that is using now
		System.out.println("in function =" + this);
	}

	public static void main(String[] args){
		ThisTest t = new ThisTest();
		t.show();
		System.out.println("t =" + t);
	}



}
*/


























/*
public class Person{

	String name;
	int age;

	//default constructor
	Person(){
		name = "nothing";
		age = 1;
		System.out.println("default constructor");
	}

	//other constructor
	Person(String name, int age){
		//same as this.name
		this.name = name;
		this.age = age;
	}
	
	//helper functions
	void grow(){
		age++;
	}

	void grow(int input){
		age+=input;
	}
	
	Person getPerson(){
		age = 88;
		name = "shabby";
		return this;
	}

	public static void main(String[] args){
		Person p = new Person("pckk", 18);
		System.out.println(p.name + p.age);
		p.grow();
		System.out.println(p.name + p.age);
		p.grow(100);
		System.out.println(p.name + p.age);
		Person new_p = p.getPerson();
		System.out.println(new_p.name + new_p.age);
	}

}
*/























/*
public class Point{

	int x;
	int y;
	
	void print(){
		System.out.println("x = " + x + " y = " + y);
	}
	
	void setX(int input){
		x = input;
	}
	
	void setY(int input){
		y = input;
	}

	void extentArgument(int... args){
		x = args[2];
	}
	
	int getX(){
		return x;
	}

	int getY(){
		return y;
	}
	
	int sum(int ix, int iy){
		x = ix;
		y = iy;
		return ix+iy;
	}
	
	public static void main(String[] args){
		Point p = new Point();
		p.print();

		p.x = 3;
		p.y = 5;				
		p.print();
		
		p.setX(1);
		p.setY(10);	
		p.print();

		p.extentArgument(4,5,6);
		p.print();
		
		System.out.println(p.getX() + p.getY());

		int result = p.sum(3,7);
		p.print();
		System.out.println(p.getX() + p.getY());
		System.out.println(result);  
	}

}
*/