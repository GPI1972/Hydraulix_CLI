/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openchannel;
import java.lang.Math;

/**
 *
 * @author PG
 */
public abstract class ChannelSection {
  public double channelSlope;
  public double roughCoeff;
  public double flowDepth;
  public double wettedArea;
  public double wettedPerimeter;
  public double hydraulicR;
  public double flowVelocity;
  public double flowRate;
  
  // constructor #1
  public ChannelSection(double channelSlope, double roughCoeff){
    //this.wettedArea = 0.0;
    //this.wettedPerimeter = 0.0;
    this.channelSlope = channelSlope;
    this.roughCoeff = roughCoeff;
  }
  
  // constructor #2
  public ChannelSection(double channelSlope, double roughCoeff, double flowDepth){
    this.channelSlope = channelSlope;
    this.roughCoeff = roughCoeff;
    this.flowDepth = flowDepth;
  }
  
  public double getChannelSlope(){
    return this.channelSlope;
  }
  
  public double getRoughCoeff(){
    return this.roughCoeff;
  }
  
  public abstract void setWettedArea();
  
  public abstract void setWettedPerimeter();
  
  public double getWettedArea(){
    return this.wettedArea;
  }
  
  public double getWettedPerimeter(){
   return this.wettedPerimeter; 
  }
  
  public void setHydraulicR(){
    this.hydraulicR = this.wettedArea / this.wettedPerimeter;
  }
  
  public double getHydraulicR(){
    return this.hydraulicR;
  }
  
  public void setVelocity(){
    this.flowVelocity = (1/this.roughCoeff) * java.lang.Math.pow(this.hydraulicR, (double) 2/3) * java.lang.Math.pow(this.channelSlope, (double) 1/2);
  }
  
  public double getVelocity(){
    return this.flowVelocity;
  }
  
  public void calcSection(){
    this.setWettedPerimeter();
    this.setWettedArea();
    this.setHydraulicR();
    this.setVelocity();
    this.flowRate = this.flowVelocity * this.wettedArea;
  }
  
  public double getFlowRate(){
    return this.flowRate;
  }
}
