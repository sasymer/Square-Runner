import java.awt.*;  //for Graphics
import javax.swing.*;  //for JComponent, JFrame
import java.net.*;  //for URL
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Game
{
  private Location first;  
  private Display display;
  public Point player;
  public ArrayList<Point> cubes;
  private Integer time;
  private boolean threeD;
  boolean alive;
  
  public Game()
  {
    player = new Point(250,450, new Color(10,200,60));
    display = new Display(this);
    display.showMessageDialog("Press left and right arrows to move.\nPress 2 to switch to 2D mode, or\n3 to switch back to 3D mode.");
    cubes = new ArrayList<Point>();
    time = 0;
    threeD = true;
    alive = true;
  }
  
  public void play()
  {
    while (alive)
    {
      boolean match = false;
      int clickNum = 0; //number of clicks so far

      int key = display.checkLastKeyPressed();
      
      if (key != -1)
        keyPressed(key);
      
      if (Math.random() < 0.005) //make the game faster by decreasing this value
        step();

      time++;
      if (time == 50)
      {
        for (int i = 0; i < cubes.size(); i++)
        {
          Point cube = cubes.get(i);
          cube.addtoY(1);
          double y = cube.getY();
          double x = cube.getX();
          if (y > 550)
          {
            cubes.remove(i);
            i--;
          }
        }
        time = 0;
      }
      for (int i = 0; i < cubes.size(); i++)
      {
        Point cube = cubes.get(i);
        //get too close to square
        if (Math.abs(player.getX()-cube.getX())<2 && Math.abs(player.getY()-cube.getY())<3)
          alive = false; //this will end the game
      }
    }
  }
  
  public Point getPlayer()
  {
    return player;
  }

  public boolean is3D()
  {
    return threeD;
  }
  
  public void make2D()
  {
    threeD = false;
  }
  
  public void make3D()
  {
    threeD = true;
  }
  
  //called when the user presses a key.
  //each key on the keyboard has a unique key code.
  //that key code is passed to this method.
  public void keyPressed(int key)
  {
    if (key == 50) //2
      make2D();
    else if (key == 51) //3
      make3D();
    else if (key == 37) //left arrow
    {
      for (Point cube : cubes)
        cube.addtoX(1);
    }
    else if (key == 39) //right arrow
    {
      for (Point cube : cubes)
        cube.addtoX(-1);
    }
    else
    {
      //some other key was pressed
      display.showMessageDialog("Please press 2, 3, left arrow, or right arrow.");
    }
    display.update();
  }
  
  //this method is called at regular intervals
  //creates new cubes
  public void step()
  {
    Color orange = new Color(250,180,60);
    Color red = new Color(250,0,0);
    Color c;
    if (Math.random() < .5)
      c = red;
    else
      c = orange;
    Point p = new Point((int)(Math.random()*500), (int)(Math.random()*10)+200, c);
    cubes.add(p);
    display.update();
  }
  
  public boolean pOnCube()
  {
    double x = player.getX();
    double y = player.getY();
    return true;
  }
  
  public ArrayList<Point> getCubes()
  {
    return cubes;
  }
  
  //this code starts a game when you click the run button
  public static void main(String[] args)
  {
    Game g = new Game();
    g.play();
  }
}
