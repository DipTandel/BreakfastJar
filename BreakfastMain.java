//BreakfastMain
//ICS4U1, Dip Tandel
//Nov 4, 2021
import java.util.Scanner;

public class BreakfastMain {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    //Creates a new object of Jar of Nutella made of glass, 100/150ml filled
    Jar j1 = new Jar("Nutella", 150, 100, false);
    //Creates a new object of Jar of Pranut Butter not made of glass, 300/400ml filled
    Jar j2 = new Jar("Peanut Butter", 400, 300, false);
    //Creates a new object of Jar of Strawberries not made of glass, 200/300ml filled
    Jar j3 = new Jar("Strawberry", 300, 200, true);
    //adds the jars into the cupboard
    Cupboard c1 = new Cupboard(j1, j2, j3);

    //Greeting
    System.out.println(
      "Good morning, are you hungry? You have some toast I see. Here in the cupboard we have three jars of spread: "
    );

    //initializing variables for use in the loop
    Boolean loop = false;
    Jar jar;
    while (loop == false) {
      //Prints what is available in the cupboard
      System.out.println(c1);

      //Selects a jar depending on user's input, if user inputs a negative number, they exit, if user inputs a number above 3, loop resets and asks again
      System.out.println("Which spread would you like? ");
      int x = in.nextInt();
      if (x > 3 || x == 0) {
        System.out.println("There are 3, please input a valid number");
        continue;
      } else if (x < 0) {
        break;
      } else {
        jar = c1.getPos(x);
        //asks the user to take some spread, if they input an invalid number, asks again
        System.out.println("How much spread do you wish to have? ");
        int n = in.nextInt();
        if (n > jar.getVolumeRemaining()) {
          System.out.println("There is not enough spread :( Try again");
          continue;
        } else if (n < 0) { //If user tries to take a negative number, asks if they want to refill, only valid refills are allowed
          System.out.println(
            "I guess you want to refill, Enter 1 to refill or enter any other number if you made a mistake and would like to restart: "
          );
          int maybeRefill = in.nextInt();
          if (maybeRefill == 1) {
            if (jar.getVolumeRemaining() == jar.getVolumeTotal()) {
              System.out.println(
                "Wait this jar is already filled! You're a trickster indeed."
              );
              continue;
            } else {
              System.out.println(
                "Enter how many millilitres you are looking to refill (Enter a non-decimal value) "
              );
              int ref = in.nextInt();
              if (ref > jar.getVolumeTotal() || ref <= 0) {
                while (ref > jar.getVolumeTotal() || ref <= 0) {
                  System.out.println(
                    "Enter an appropriate value, how much do you want to refill? "
                  );
                  ref = in.nextInt();
                }
              }
              jar.refill(ref);
            }
            System.out.println("Cool! Anything else?");
          }
        } else if (n == 0) {
          jar.spread(n);
          System.out.println("umm it won't eat itself. Take some? ");
        } else {
          jar.spread(n);
          System.out.println("Nice! Some more?");
        }
        //When all the jars are empty the user is reminded that there is a way to fill the jars and has the choice to make a new one
        if (
          j1.getVolumeRemaining() == 0 &&
          j2.getVolumeRemaining() == 0 &&
          j3.getVolumeRemaining() == 0
        ) {
          System.out.println(c1);
          System.out.println(
            "If you don't know, you can ask for a negative number of spread in order to refill the specified jar"
          );
          System.out.println("Or do you want to make a new jar?");
          System.out.println(
            "Enter 1 to make a new jar. Or Enter any other number to continue: "
          );
          int out = in.nextInt();
          if (out == 1) {
            System.out.println(
              "Ok, what kind of spread? (ie. Nutella, only one word please) "
            );
            String t = in.next();
            System.out.println(
              "How many millilitres can this jar hold in total (Enter a non-decimal value) "
            );
            int v = in.nextInt();
            System.out.println("How much of that should be filled? ");
            int r = in.nextInt();
            if (r > v || r < 0) {
              while (r > v || r < 0) {
                System.out.println(
                  "Stop and enter an appropriate value, how much of that should be filled? "
                );
                r = in.nextInt();
              }
            }
            System.out.println(
              "Is this a glass jar? (Enter 1 if glass, or another number if not) "
            );
            int gtemp = in.nextInt();
            Boolean g = false;
            if (gtemp == 1) {
              g = true;
            } else {
              g = false;
            }
            System.out.println(
              "Finally, which current jar should be replaced in exchange for this one? 1, 2, or 3? "
            );
            int getOut = in.nextInt();
            if (getOut < 1 || getOut > 3) {
              while (getOut < 1 || getOut > 3) {
                System.out.println(
                  "There are 3 jars currently, replace 1, 2, or 3? "
                );
                getOut = in.nextInt();
              }
            }
            Jar newJar = new Jar(t, v, r, g);
            c1.replace(getOut, newJar);
            System.out.println("Done!");
          } else {
            continue;
          }
        }
      }
    }

    //farewell
    System.out.println("Goodbye, I hope you're full!");
  }
}
