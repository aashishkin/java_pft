package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args){
        hello("User");
        String someString = "Hello!";
        System.out.println(2 + 2);
        System.out.println(2 * 2);
        System.out.println(2 / 2);
        System.out.println(2 - 2);

        System.out.println(1 / 2);
        System.out.println(1.0 / 2);
        System.out.println(1 / 2.0);
        System.out.println(2 / 2.0);

        System.out.println("2" + "2");

        System.out.println("2" + 2);

        System.out.println("2 + 2 = " + (2+2));

        Square s = new Square(5);


        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());


        Rectangle r = new Rectangle(8,9);


        System.out.println("Площадь прямоугольника со сторонами " + r.a + ", " + r.b  + " равна " + r.area());

        Rectangle r2 = new Rectangle(9,11);
        System.out.println(r2.a);
        System.out.println(r2.b);

    }
    public static void hello(String somebody){
        System.out.println("Hello, " + somebody + "!");
    }




}
