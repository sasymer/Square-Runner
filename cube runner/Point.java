import java.awt.*;  //for Graphics
import javax.swing.*;  //for JComponent, JFrame
import java.net.*;  //for URL
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Point implements Shape
{
  private double x;
  private double y;
  private double z;
  private Color color;
  
  public Point(double x, double y, Color c)
  {
    this.x = x;
    this.y = y;
    z = 0;
    color = c;
  }
  
  public Point(double x, double y, double z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public double getX()
  {
    return x;
  }
  
  public double getY()
  {
    return y;
  }
  
  public double getZ()
  {
    return z;
  }
  
  public Color getColor()
  {
    return color;
  }
  
  public void addtoX(double add)
  {
    x += add;
  }
  
  public void addtoY(double add)
  {
    y += add;
  }
  
  public void addtoZ(double add)
  {
    z += add;
  }
  
  public Point center()
  {
    return this;
  }
  
  public double distance(Point p)
  {
    double xs = getX() - p.getX();
    double ys = getY() - p.getY();
    double zs = getZ() - p.getZ();
    return Math.sqrt(xs*xs + ys*ys + zs*zs);
  }
  
  public void move(double x, double y, double z)
  {
    this.x = x; this.y = y; this.z = z;
  }
}