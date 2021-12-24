/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openchannel;

/**
 *
 * @author PG
 */
public class CircSection extends ChannelSection {
  private double radius;
  private double theta;
  
  public CircSection(double channelSlope, double roughCoeff, double radius, double flowDepth){
    super(channelSlope, roughCoeff);
    this.radius = radius;
    this.flowDepth = flowDepth;
    this.theta = java.lang.Math.acos((1 - (this.flowDepth / this.radius)));
  }
  
  @Override
  public void setWettedArea(){
    this.wettedArea = (java.lang.Math.pow(2 * this.radius, 2)/4) * (this.theta - (java.lang.Math.sin(2 * this.theta)/2));
  }
  
  @Override
  public void setWettedPerimeter(){
    this.wettedPerimeter = this.theta * (this.radius * 2);
  }
}
