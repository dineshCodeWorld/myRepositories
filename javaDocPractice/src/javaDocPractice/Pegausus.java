package javaDocPractice;


public class Pegausus extends Horse implements Flyer, Mythical {
	
	public void s()
	{
		String s = Flyer.super.identifyMyself();
		System.out.println(s);
	}
	
    public static void main(String... args) throws CloneNotSupportedException {
        Pegausus myApp = new Pegausus();
       myApp.s();
        myApp.clone();
        System.out.println( myApp.identifyMyself());
      //
    }
//
//	@Override
//	public String identifyMyself() {
//		// TODO Auto-generated method stub
//		return Flyer.super.identifyMyself();
//	}

//	@Override
//	public String identifyMyself() {
//		// TODO Auto-generated method stub
//		return Mythical.super.identifyMyself();
//	}
}