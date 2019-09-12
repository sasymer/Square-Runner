import java.awt.*;  //for Graphics
import javax.swing.*;  //for JComponent, JFrame
import java.net.*;  //for URL
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Display extends JComponent implements MouseListener,ActionListener,KeyListener
{
  private boolean start;
  private Game game;
  private JLabel infoLabel;
  private JLabel infoLabel2;
  private String labelInfo;
  JFrame frame;
  private Location lastLocationClicked;
  private int lastKeyPressed;
  private Point player;
  private ArrayList<Point> cubes;
  private final double VCONST = 350;
  private final double HCONST = 200;
  
  public Display(Game g)
  {
    game = g;
    start = true;
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
    lastKeyPressed = -1;
    player = g.getPlayer();
    cubes = g.getCubes();
    
    setPreferredSize(new Dimension(500, 550));
    
    frame.getContentPane().setBackground(new Color(0,0,0));
    frame.getContentPane().add(this);
    addMouseListener(this);
    addKeyListener(this); //frame, tie to correct thing
    frame.addMouseListener(this);
    frame.addKeyListener(this);

    frame.pack();
    frame.setVisible(true);
  }   
  
//draw things in here
//magically called whenever java feels like it
  public void paintComponent(Graphics g)
  {  
    cubes = game.getCubes();
    if (!game.is3D()) //2D
    {
      drawPoint(g, player.getX(), player.getY(), player.getZ(), player.getColor());
      if (cubes != null && !cubes.isEmpty())
      {
        for (Point cube : cubes)
        {
          double relx = cube.getX() - player.getX();
          double rely = cube.getY() - player.getY();
          drawPoint(g, cube.getX(), cube.getY(), cube.getZ(), cube.getColor());
        }
      }
    }
    else //is3D
    {
      drawPlayer(g, player.getColor());
      if (cubes != null && !cubes.isEmpty())
      {
        for (Point cube : cubes)
        {
          double relx = cube.getX() - player.getX();
          double rely = cube.getY() - player.getY();
          double toHoriz = -rely;
          if (toHoriz > 0)
          {
            double appHeight = VCONST / toHoriz;
            double screenx = HCONST * relx / toHoriz;
            drawSquare(g, cube, cube.getColor(), appHeight, screenx);
          }
        }
      }
    }
    updateLabel();
  }
  

  public void updateLabel()
  {
    
  }
  
  public void drawCircle(Graphics g, double x, double y, double z, int diameter, Color c)
  {
    g.setColor(c);
    g.fillOval((int)x, (int)y, diameter, diameter);
  }
  
  public void drawPoint(Graphics g, double x, double y, double z, Color c)
  {
    g.setColor(c);
    g.fillOval((int)x, (int)y, 10, 10);
  }
  
  public void drawPlayer(Graphics g, Color c)
  {
    g.setColor(c);
    g.drawLine(240,518,264,501);
    g.drawLine(240,518,291,518);
    g.drawLine(264,501,291,518);
  }
  
  public void drawLine(Graphics g, Point p, Color c, double appHeight, double screenx)
  {
    g.setColor(c);
    double relx = p.getX() - player.getX();
    double rely = p.getY() - player.getY();
    g.drawLine((int)(250 + screenx), (int)(450 - appHeight), (int)(250 + screenx), (int)(450 + appHeight));
  }
  
  public void drawSquare(Graphics g, Point p, Color c, double appHeight, double screenx)
  {
    g.setColor(c);
    double relx = p.getX() - player.getX();
    double rely = p.getY() - player.getY();
    double distApart = 2*appHeight;
    g.drawLine((int)(250 + screenx), (int)(450 - appHeight), (int)(250 + screenx), (int)(450 + appHeight));
    g.drawLine((int)(250 + screenx + distApart), (int)(450 - appHeight), (int)(250 + screenx + distApart), (int)(450 + appHeight));
    g.drawLine((int)(250 + screenx), (int)(450 - appHeight), (int)(250 + screenx + distApart), (int)(450 - appHeight));
    g.drawLine((int)(250 + screenx), (int)(450 - appHeight + distApart), (int)(250 + screenx+distApart), (int)(450 - appHeight + distApart));
  }
  
  public void showMessageDialog(String message)
  {
    JOptionPane.showMessageDialog(this, message);
  }
  
  public void getClick()
  {
    
  }
  
  public void update()
  {
    repaint();  //java:  "when i have time, call paintComponent"
    try{Thread.sleep(100);}catch(Exception e){}
  }
  
  public void mouseExited(MouseEvent e)
  {
  }
  
  public void mouseEntered(MouseEvent e)
  {
  }
  
  public void mouseReleased(MouseEvent e)
  {
  }
  
  public void mousePressed(MouseEvent e)
  {
    lastLocationClicked = new Location(e.getX(), e.getY());
  }
  
  public void mouseClicked(MouseEvent e)
  {
  }
  
  public void keyPressed(KeyEvent e)
  {
    lastKeyPressed = e.getKeyCode();
    game.keyPressed(e.getKeyCode());
  }
  
  public void keyReleased(KeyEvent e)
  {
    //ignored
  }
  
  public void keyTyped(KeyEvent e)
  {
    //ignored
  }
  
  //waits for user to click on screen, and returns coordinates
  public Location getClickedLocation()
  {
    lastLocationClicked = null;
    while (lastLocationClicked == null)
    {
      try{Thread.sleep(100);}catch(Exception e){};
    }
    return lastLocationClicked;
  }
  
  public int getKeyPressed()
  {
    lastKeyPressed = -1;
    while (lastKeyPressed == -1)
    {
      try{Thread.sleep(100);}catch(Exception e){};
    }
    return lastKeyPressed;
  }
  
//  returns -1 if no key pressed since last call.
//    otherwise returns the code for the last key pressed.
  public int checkLastKeyPressed()
  {
    int key = lastKeyPressed;
    lastKeyPressed = -1;
    return key;
  }
  
  //returns null if no location clicked since last call.
  public Location checkLastLocationClicked()
  {
    Location loc = lastLocationClicked;
    lastLocationClicked = null;
    return loc;
  }
  
  public static void pause(int milliseconds)
  {
    try
    {
      Thread.sleep(milliseconds);
    }
    catch(Exception e)
    {
    }
  }
  
  public void actionPerformed(ActionEvent e)
  {
    String command = e.getActionCommand();
  }
}
