class Dog {
    String dogName ;
    int Age     ;
    void bark()
    {
        System.out.println( dogName + " Barks    :" + "  lol lol lol lol");
    }
    void eat()
    {
        System.out.println( dogName +  " Eats     :  Yum Yum Yum");
    }
}



public class arrayObject 
{
    public static void main(String[] args)
    {
        int val = 7 ;
        Dog[] dogs = new Dog[val] ;
        String[] names = new String[7] ;
        names[0] = "Allice" ;
        names[1] = "Diana"  ;
        names[2] = "Mike"   ;
        names[3] = "Jimmy"  ;
        names[4] = "Laddu"  ;
        names[5] = "Sweety" ;
        names[6] = "Harry"  ;
        for(int i=0; i < val ; i++)
        {
            dogs[i] = new Dog() ;
            dogs[i].dogName = names[i] ;
            dogs[i].Age = 5            ;
            dogs[i].bark()             ;
            dogs[i].eat();  
        }
    }
}