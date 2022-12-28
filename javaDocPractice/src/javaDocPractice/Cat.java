package javaDocPractice;

public final class Cat extends Animal {

    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
	@Override
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        
      //  Animal myAnimal = myCat;
      //  Animal.testClassMethod();
       // myAnimal.testInstanceMethod();
        myCat.testClassMethod();
        myCat.testInstanceMethod();
    }
}