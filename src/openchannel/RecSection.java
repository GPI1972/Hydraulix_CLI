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
public class RecSection extends ChannelSection {
  private double width;
    
  public RecSection(double channelSlope, double roughCoeff, double width, double flowDepth){
    super(channelSlope, roughCoeff);
    this.width = width;
    this.flowDepth = flowDepth;
  }
  
  @Override
  public void setWettedArea(){
    this.wettedArea = this.width * this.flowDepth;
  }
  
  @Override
  public void setWettedPerimeter(){
    this.wettedPerimeter = this.width + (2 * this.flowDepth);
  }
}
