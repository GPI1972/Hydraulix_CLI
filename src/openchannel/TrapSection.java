/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package openchannel;

/**
 *
 * @author PG
 */
public class TrapSection extends ChannelSection {
  private double bottomWidth;
  private double lSideSlope;
  private double rSideSlope;
  private double lAlpha;
  private double rAlpha;
  private double lAddWidth;
  private double rAddWidth;
  private double topWidth;
  private double lFaceLength;
  private double rFaceLength;
  
  
  public TrapSection(double channelSlope, double roughCoeff, double bottomWidth, double leftSideSlope, double rightSideSlope, double flowDepth){
    super(channelSlope, roughCoeff);
    this.bottomWidth = bottomWidth;
    this.flowDepth = flowDepth;
    this.lSideSlope = leftSideSlope;
    this.rSideSlope = rightSideSlope;
    this.lAddWidth = flowDepth / leftSideSlope;
    this.rAddWidth = flowDepth / rightSideSlope;
    this.lAlpha = java.lang.Math.atan(flowDepth / lAddWidth);
    this.rAlpha = java.lang.Math.atan(flowDepth / rAddWidth);
    this.topWidth = this.bottomWidth + this.lAddWidth + this.rAddWidth;
    this.lFaceLength = this.flowDepth / java.lang.Math.sin(this.lAlpha);
    this.rFaceLength = this.flowDepth / java.lang.Math.sin(this.rAlpha);
  }
  
  @Override
  public void setWettedArea(){
    this.wettedArea = ((this.topWidth + this.bottomWidth) / 2) * this.flowDepth;
  }
  
  @Override
  public void setWettedPerimeter(){
    this.wettedPerimeter = this.bottomWidth + this.lFaceLength + this.rFaceLength;
  }
}
