/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openchannel;
import java.util.Scanner;

/**
 *
 * @author PG
 */
public class OpenChannel {

  private static Scanner userin = new Scanner(System.in);
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int input = -1;
    
    do {
      // Define section geometry & characteristics
      System.out.println("\n" + "------------------------");
      System.out.println("Define channel section");
      System.out.println("1: Rectangular Channel");
      System.out.println("2: Circular Channel");
      System.out.println("3: Trapezoidal Channel");
      System.out.println("9: Quit");
      
      try {
	System.out.println("\n" + "Enter selection:");
        input = userin.nextInt();
      } catch(Exception e) {
	userin.nextLine();
	System.out.println("Invalid choice...\n");
	continue;
      }

      userin.nextLine();
      System.out.println();

      if(input == 1) {
	System.out.println("Rectangular Channel");
        double width = getInput("Enter width of channel: ");
        double flowDepth = getInput("Enter water depth: ");
        double channelSlope = getInput("Enter slope of channel: ");
        double roughCoeff = getInput("Enter Manning's roughness coefficient: ");
        
        ChannelSection rectChannel = new RecSection(channelSlope, roughCoeff, width, flowDepth);
        rectChannel.calcSection();
        
        System.out.println("\nSlope: " + rectChannel.getChannelSlope());
        System.out.println("Roughness coeff: " + rectChannel.getRoughCoeff());
        System.out.printf("Wetted perimeter: %.3f m", rectChannel.getWettedPerimeter());
        System.out.printf("\nWetted area: %.3f m^2", rectChannel.getWettedArea());
        System.out.printf("\nHydraulic radius: %.3f m", rectChannel.getHydraulicR());
        System.out.printf("\nVelocity: %.3f m/s", rectChannel.getVelocity());
        System.out.printf("\nFlow rate: %.3f m^3/s\n", rectChannel.getFlowRate());
        
        
      } else if(input == 2) {
	System.out.println("Circular Channel");
        double radius = getInput("Enter radius of channel: ");
        double flowDepth = getInput("Enter water depth: ");
        double channelSlope = getInput("Enter slope of channel: ");
        double roughCoeff = getInput("Enter Manning's roughness coefficient: ");
        
        ChannelSection circChannel = new CircSection(channelSlope, roughCoeff, radius, flowDepth);
        circChannel.calcSection();
        
        System.out.println("\nSlope: " + circChannel.getChannelSlope());
        System.out.println("Roughness coeff: " + circChannel.getRoughCoeff());
        System.out.printf("Wetted perimeter: %.3f m", circChannel.getWettedPerimeter());
        System.out.printf("\nWetted area: %.3f m^2", circChannel.getWettedArea());
        System.out.printf("\nHydraulic radius: %.3f m", circChannel.getHydraulicR());
        System.out.printf("\nVelocity: %.3f m/s", circChannel.getVelocity());
        System.out.printf("\nFlow rate: %.3f m^3/s\n", circChannel.getFlowRate());
        
      } else if(input == 3) {
	System.out.println("Trapezoidal Channel");
        double bottomWidth = getInput("Enter bottom width of channel: ");
        double leftSideSlope = getInput("Enter side slope (LHS) of channel (1:V): ");
        double rightSideSlope = getInput("Enter side slope (RHS) of channel (1:V): ");
        double flowDepth = getInput("Enter water depth: ");
        double channelSlope = getInput("Enter slope of channel: ");
        double roughCoeff = getInput("Enter Manning's roughness coefficient: ");
        
        ChannelSection trapChannel = new TrapSection(channelSlope, roughCoeff, bottomWidth, leftSideSlope, rightSideSlope, flowDepth);
        trapChannel.calcSection();
        
        System.out.println("\nSlope: " + trapChannel.getChannelSlope());
        System.out.println("Roughness coeff: " + trapChannel.getRoughCoeff());
        System.out.printf("Wetted perimeter: %.3f m", trapChannel.getWettedPerimeter());
        System.out.printf("\nWetted area: %.3f m^2", trapChannel.getWettedArea());
        System.out.printf("\nHydraulic radius: %.3f m", trapChannel.getHydraulicR());
        System.out.printf("\nVelocity: %.3f m/s", trapChannel.getVelocity());
        System.out.printf("\nFlow rate: %.3f m^3/s\n", trapChannel.getFlowRate());
        
      } else if(input != 9) {
	System.out.println("Invalid selection...");
      }

      if(input != 9) pause();
    } while(input != 9);
  }
  
  private static void pause() {
    // clear the current scanner buffer and gets ready for next input
    userin.nextLine();
    
    System.out.println("\n(Press enter to continue...)");
    userin.nextLine();
  }
  
  private static double getInput(String message){
    double input = -999;
    do{
      System.out.print(message);
      try{
        input = userin.nextDouble();
        // check for negative inputs
        if (input <= 0){
          throw new Exception();
        }
      } catch(Exception e){
        userin.nextLine();
        System.out.println("Invalid input. Please try again.");
        input = -999;
      }
    } while (input == -999);
    return input;
  }
}
