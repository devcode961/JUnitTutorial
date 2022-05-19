package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App app = new App();

         app.printStuff();

         String x = "ab";

         StringBuilder d = new StringBuilder();

         d.append(x.charAt(1));

        System.out.println(d);




    }

    private void printStuff(){
        System.out.println("Hello world");
    }

}
