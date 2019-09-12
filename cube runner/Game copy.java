public class Game
{
  private GridDisplay display;
  private Location loc1;
  private Location loc2;
  private Location loc3;
  private Location loc4;
  private Location loc5;
  private Location loc6;
  private Location loc7;
  private Location loc8;
  private Location loc9;
  private Location loc10;
  private Location loc11;
  private Location loc12;
  private Location loc13;
  private Location loc14;
  private Location loc15;
  private Location loc16;
  private Location loc17;
  private Location loc18;
  private Location loc19;
  private Location loc20;
  private Location loc21;
  private Location loc22;
  private Location loc23;
  private Location loc24;
  
  private Location first;  //location of first card turned up.  null if none up.
  
  private int matches;
  
  private int turn;
    
  private String pic1;
  private String pic2;
  private String pic3;
  private String pic4;
  private String pic5;
  private String pic6;
  private String pic7;
  private String pic8;
  private String pic9;
  private String pic10;
  private String pic11;
  private String pic12;

  public Game()
  {
    //create GridDisplay with 5 rows and 8 columns, and title "Game"
    display = new GridDisplay(4, 6);
    display.setTitle("Memory Game");
    
    loc1 = new Location(3, 0);
    display.setImage(loc1, "anna.jpg");
    display.setImage(loc1, "cardanna.jpg");
    
    loc2 = new Location(3, 1);
    display.setImage(loc2, "mulan.png");
    display.setImage(loc2, "cardmulan.jpg");
    
    loc3 = new Location(3, 2);
    display.setImage(loc3, "cinderella.png");
    display.setImage(loc3, "cardcinderella.jpg");
    
    loc4 = new Location(3, 3);
    display.setImage(loc4, "aurora.png");
    display.setImage(loc4, "cardaurora.jpg");
    
    loc5 = new Location(3, 4);
    display.setImage(loc5, "snow.png");
    display.setImage(loc5, "cardsnow.jpg");
    
    loc6 = new Location(3, 5);
    display.setImage(loc6, "merida.png");
    display.setImage(loc6, "cardmerida.jpg");
    
    loc7 = new Location(2, 0);
    display.setImage(loc7, "pocahontas.png");
    display.setImage(loc7, "cardpocahontas.jpg");
    
    loc8 = new Location(2, 1);
    display.setImage(loc8, "ariel.png");
    display.setImage(loc8, "cardariel.jpg");
    
    loc9 = new Location(2, 2);
    display.setImage(loc9, "mulan.png");
    display.setImage(loc9, "cardmulan.jpg");
    
    loc10 = new Location(2, 3);
    display.setImage(loc10, "elsa.jpg");
    display.setImage(loc10, "cardelsa.jpg");
    
    loc11 = new Location(2, 4);
    display.setImage(loc11, "rapunzel.jpg");
    display.setImage(loc11, "cardrapunzel.jpg");
    
    loc12 = new Location(2, 5);
    display.setImage(loc12, "belle.png");
    display.setImage(loc12, "cardbelle.jpg");
    
    loc13 = new Location(1, 0);
    display.setImage(loc13, "elsa.jpg");
    display.setImage(loc13, "cardelsa.jpg");
    
    loc14 = new Location(1, 1);
    display.setImage(loc14, "pocahontas.png");
    display.setImage(loc14, "cardpocahontas.jpg");
    
    loc15 = new Location(1, 2);
    display.setImage(loc15, "belle.png");
    display.setImage(loc15, "cardbelle.jpg");
    
    loc16 = new Location(1, 3);
    display.setImage(loc16, "anna.jpg");
    display.setImage(loc16, "cardanna.jpg");
    
    loc17 = new Location(1, 4);
    display.setImage(loc17, "tatianna.png");
    display.setImage(loc17, "cardtatianna.jpg");
    
    loc18 = new Location(1, 5);
    display.setImage(loc18, "tatianna.png");
    display.setImage(loc18, "cardtatianna.jpg");
    
    loc19 = new Location(0, 0);
    display.setImage(loc19, "aurora.png");
    display.setImage(loc19, "cardaurora.jpg");
    
    loc20 = new Location(0, 1);
    display.setImage(loc20, "ariel.png");
    display.setImage(loc20, "cardariel.jpg");
    
    loc21 = new Location(0, 2);
    display.setImage(loc21, "snow.png");
    display.setImage(loc21, "cardsnow.jpg");
    
    loc22 = new Location(0, 3);
    display.setImage(loc22, "rapunzel.jpg");
    display.setImage(loc22, "cardrapunzel.jpg");
    
    loc23 = new Location(0, 4);
    display.setImage(loc23, "merida.png");
    display.setImage(loc23, "cardmerida.jpg");
    
    loc24 = new Location(0, 5);
    display.setImage(loc24, "cinderella.png");
    display.setImage(loc24, "cardcinderella.jpg");
    
    for (int i = 0; i < 100; i++)
    {
      int row = (int)(Math.random() * 4);
      int col = (int)(Math.random() * 6);
      
      int row2 = (int)(Math.random() * 4);
      int col2 = (int)(Math.random() * 6);
      
      Location switcher = new Location(row, col);
      String a = display.getImage(switcher);
      Location switcher2 = new Location(row2, col2);
      String b = display.getImage(switcher2);
      
      display.setImage(switcher, b);
      display.setImage(switcher2, a);
    }
    
  }
  
  public void play()
  {
    display.showMessageDialog("Click on two cards to find a match. \nDo not click on a card showing a princess. \nIf you do there will be an error :(");
    while (true)
    {
      boolean match = false;
      int clickNum = 0; //number of clicks so far

      //wait 100 milliseconds for mouse or keyboard
      display.pause(100);
      
      //check if any locations clicked or keys pressed
      Location clickLoc = display.checkLastLocationClicked();
      
      int key = display.checkLastKeyPressed();
      
      if (clickLoc != null)
      {
        //a location was clicked
        locationClicked(clickLoc);
      }
    }
  }

  public boolean isUp(Location loc)
  {
    if (!display.getImage(loc).equals("card.jpg"))
    {
      return true;
    }
    else
      return false;
  }
  
  public void turnUp(Location loc)
  {
    String image;
    if(display.getImage(loc) != null)
    {
      if (display.getImage(loc).equals("cardanna.jpg"))
      {
        image = "anna.jpg";
      }
      else if (display.getImage(loc).equals("cardmulan.jpg"))
      {
        image = "mulan.png";
      }
      else if (display.getImage(loc).equals("cardelsa.jpg"))
      {
        image = "elsa.jpg";
      }
      else if (display.getImage(loc).equals("cardsnow.jpg"))
      {
        image = "snow.png";
      }
      else if (display.getImage(loc).equals("cardtatianna.jpg"))
      {
        image = "tatianna.png";
      }
      else if (display.getImage(loc).equals("cardcinderella.jpg"))
      {
        image = "cinderella.png";
      }
      else if (display.getImage(loc).equals("cardariel.jpg"))
      {
        image = "ariel.png";
      }
      else if (display.getImage(loc).equals("cardpocahontas.jpg"))
      {
        image = "pocahontas.png";
      }
      else if (display.getImage(loc).equals("cardaurora.jpg"))
      {
        image = "aurora.png";
      }
      else if (display.getImage(loc).equals("cardbelle.jpg"))
      {
        image = "belle.png";
      }
      else if (display.getImage(loc).equals("cardmerida.jpg"))
      {
        image = "merida.png";
      }
      else if (display.getImage(loc).equals("cardrapunzel.jpg"))
      {
        image = "rapunzel.jpg";
      }
      else
      {
        image = null;
        throw new RuntimeException("cannot find " + display.getImage(loc));
      }
    }
      else
      {
        image = null;
        throw new RuntimeException("cannot find " + display.getImage(loc));
      }
  
    
    display.setImage(loc, image);

  }
  
  public void downFace(Location loc)
  {
    display.setImage(loc, "card.jpg");
  }
  
  public void turnDown(Location loc)
  {
    if (display.getImage(loc) != null)
    {
      if (display.getImage(loc).equals("anna.jpg"))
      {
        display.setImage(loc, "cardanna.jpg");
      }
      if (display.getImage(loc).equals("ariel.png"))
      {
        display.setImage(loc, "cardariel.jpg");
      }
      if (display.getImage(loc).equals("aurora.png"))
      {
        display.setImage(loc, "cardaurora.jpg");
      }
      if (display.getImage(loc).equals("belle.png"))
      {
        display.setImage(loc, "cardbelle.jpg");
      }
      if (display.getImage(loc).equals("cinderella.png"))
      {
        display.setImage(loc, "cardcinderella.jpg");
      }
      if (display.getImage(loc).equals("elsa.jpg"))
      {
        display.setImage(loc, "cardelsa.jpg");
      }
      if (display.getImage(loc).equals("merida.png"))
      {
        display.setImage(loc, "cardmerida.jpg");
      }
      if (display.getImage(loc).equals("mulan.png"))
      {
        display.setImage(loc, "cardmulan.jpg");
      }
      if (display.getImage(loc).equals("pocahontas.png"))
      {
        display.setImage(loc, "cardpocahontas.jpg");
      }
      if (display.getImage(loc).equals("rapunzel.jpg"))
      {
        display.setImage(loc, "cardrapunzel.jpg");
      }
      if (display.getImage(loc).equals("snow.png"))
      {
        display.setImage(loc, "cardsnow.jpg");
      }
      if (display.getImage(loc).equals("tatianna.png"))
      {
        display.setImage(loc, "cardtatianna.jpg");
      }
    }
    
  }
  

  
  //called when the user clicks on a location.
  //that location is passed to this method.
  private void locationClicked(Location loc)
  {
    boolean match = false;
    if (first != null)
    {
      System.out.println("second click:  " + loc);
      //second click
      turnUp(loc);
      if (display.getImage(loc) != null && display.getImage(loc).equals(display.getImage(first)))
      {
        System.out.println("match");
        match = true;
        display.pause(1000);
        display.setImage(loc, null);
        display.setImage(first, null);
        matches = matches + 1;
        if (matches == 12)
        {
          display.showMessageDialog("turns =  " + turn);
          GridDisplay x = new GridDisplay("win.jpg");
        //  x.setImage(new Location(0,0), 
        }
      }
     
      else
      {
        System.out.println("mismatch");
        display.pause(1000);
        match = false;
        turnDown(loc);
        turnDown(first);
        
      }
      first = null;
      turn = turn + 1;
      System.out.println("turn:  " + turn);
    }
    else
    {
      System.out.println("first click:  " + loc);
      //first click
      turnUp(loc);
      first = loc;
    }
    
//    
//    if (isup1 == true)
//    {
//      turnDown(loc);
//    }
//    else
//    {
//      turnUp(loc);
//    }
 
    
   // if (display.getImage(loc) != "card.jpg")
   // {
     // image = "card.jpg";
   // }
    
    //display.setImage(loc, image);
    
  }
  
  public boolean lastClickedSame()
  {
    
    return true;
  }
  
  //called when the user presses a key.
  //each key on the keyboard has a unique key code.
  //that key code is passed to this method.
  private void keyPressed(int key)
  {
    //print key code
    System.out.println("key code:  " + key);
        
    if (key == 32)
    {
      //space key was pressed

      //pick new location for hero
      int col = loc1.getCol();
      Location newLoc;
      if (col == 4)
        newLoc = new Location(2, 0);  //bottom-left cell
      else
        newLoc = new Location(2, col + 1);  //next cell to right
      
      //erase image at old location
      display.setImage(loc1, null);
      
      //remember new location
      loc1 = newLoc;
      
      //show image at new location
      display.setImage(loc1, pic1);
    }
    else
    {
      //some other key was pressed
      
      //show help message
      display.showMessageDialog("Click on two cards to find a match.");
    }
  }
  
  //this method is called at regular intervals
  public void step(Location loc)
  {
    //maybe change color of random location to black
    if (Math.random() < 0.1)
    {
      int row = (int)(Math.random() * 3);
      int col = (int)(Math.random() * 5);
      display.setImage(loc, "card.jpg");
    }
  }
  
  //this code starts a game when you click the run button
  public static void main(String[] args)
  {
    Game g = new Game();
    g.play();
  }
}
