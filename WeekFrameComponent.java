import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.awt.Font;



public class WeekFrameComponent extends JComponent
{
    private GregorianCalendar gregDay;
    
    public WeekFrameComponent(GregorianCalendar validSunday)
    {
         gregDay = validSunday;
    }
        
                
    public void paintComponent(Graphics g)
    /*
     * The int x and int y are for the smiley face.
     * It then draws the boxes for the days of the week, and prints the days of the month based on what the user entered.
     * The head of the smiley face is drawn in black and filled with yellow at the coordinates (x, y).
     * Then, the eyes are drawn depending on where the head is drawn.
     * Then, the smile is drawn depending on where the head and eyes are drawn.
     * Writes the days of the week above the colored rectangles that were previously drawn.
     */
    {
        Graphics2D g2 = (Graphics2D) g;
    
        String dateStr = getDateString();
        g2.setColor(Color.BLACK);
        g2.drawString(dateStr, 300, 40);
        
        //String str1 = "Font: " + g2.getFont().getFontName();
        //String str2 = "Size: " + String.valueOf ( g2.getFont().getSize() );
        
        //g2.drawString(str1, 10, 375);
        //g2.drawString(str2, 300, 375);

        int x = 24 + (gregDay.get(GregorianCalendar.DAY_OF_WEEK) - 1)*100;
        int y = 103;
        
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, -(gregDay.get(GregorianCalendar.DAY_OF_WEEK) - 1));
        int day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        
        
        String str = String.valueOf( day1 );
        //Sunday
        //-------------------------------------
        g2.setColor(Color.PINK);
        Rectangle pinkDay = new Rectangle(10, 100, 100, 75);
        g2.draw(pinkDay);
        g2.fill(pinkDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 20, 165);
        
        //Monday
        //-----------------
        
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        g2.setColor(Color.BLUE);
        Rectangle blueDay = new Rectangle(110, 100, 100, 75);
        g2.draw(blueDay);
        g2.fill(blueDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 120, 165);
        
        //Tuesday
        //----------------------
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        g2.setColor(Color.RED);
        Rectangle redDay = new Rectangle(210, 100, 100, 75);
        g2.draw(redDay);
        g2.fill(redDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 220, 165);
        
        // Wednesday
        //-----------------------
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        g2.setColor(Color.DARK_GRAY);
        Rectangle grayDay = new Rectangle(310, 100, 100, 75);
        g2.draw(grayDay);
        g2.fill(grayDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 320, 165);
        
        // Thursday
        //----------------------
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        g2.setColor(Color.MAGENTA);
        Rectangle magentaDay = new Rectangle(410, 100, 100, 75);
        g2.draw(magentaDay);
        g2.fill(magentaDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 420, 165);
        
        // Friday
        //---------------------------
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        g2.setColor(Color.ORANGE);
        Rectangle orangeDay = new Rectangle(510, 100, 100, 75);
        g2.draw(orangeDay);
        g2.fill(orangeDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 520, 165);
        
        //Saturday
        //---------------------------
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, 1);
        day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        str =String.valueOf( day1 );
        
        Color navyBlue = new Color(20, 50, 100);
        g2.setColor(navyBlue);
        Rectangle navyBlueDay = new Rectangle(610, 100, 100, 75);
        g2.draw(navyBlueDay);
        g2.fill(navyBlueDay);
        g2.setColor(Color.WHITE);
        g2.drawString(str, 620, 165);
        
        // smiley face
        
        g2.setColor(Color.BLACK);
        Ellipse2D.Double head = new Ellipse2D.Double(x, y, 70, 70);
        g2.draw(head);
        g2.setColor(Color.YELLOW);
        g2.fill(head);
        
        g2.setColor(Color.BLACK);
        Ellipse2D.Double eye1 = new Ellipse2D.Double(x + 14.5, y + 17, 12, 12);
        g2.draw(eye1);
        g2.fill(eye1);
        
        Ellipse2D.Double eye2 = new Ellipse2D.Double(x + 44, y + 17, 12, 12);
        g2.draw(eye2);
        g2.fill(eye2);
        
        // this is the smile on the face
        g2.drawArc(x + 14, y + 16, 43, 43, 180, 180);
        
        
        g2.setColor(Color.BLACK);
        
        // printing the days of the week above each rectangle
        g2.drawString("Sunday", 36, 94);
        g2.drawString("Monday", 136, 94);
        g2.drawString("Tuesday", 232, 94);
        g2.drawString("Wednesday", 326, 94);
        g2.drawString("Thursday", 430, 94);
        g2.drawString("Friday", 538, 94);
        g2.drawString("Saturday", 632, 94);
        
    }
    
    public void drawDay(Graphics g2, int x, int y, Color c, int addDays)
    /*
     * This method is used to draw the day of the month.
     */
    {
        gregDay.add(GregorianCalendar.DAY_OF_MONTH, addDays);
        int day1 = gregDay.get(GregorianCalendar.DAY_OF_MONTH);
        
        
        String str = String.valueOf( day1 );
        
        g2.setColor(c);
        g2.drawString(str, x, y);
    }
    
    public String monthName( ){
        /*
         * A switch block is like a big if statement.
         * Depending on what "month" is, the switch block will break when the correct month is reached. 
         */
        int month = gregDay.get(GregorianCalendar.MONTH) + 1;
         String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        return monthString;
    }
    
    public String weekString()
    /*
     * Same thing as above, but with weekdays.
     */
    {
        int weekDay = gregDay.get(GregorianCalendar.DAY_OF_WEEK);
         String wS;
        switch (weekDay) {
            case 1:  wS = "Sunday";
                     break;
            case 2:  wS = "Monday";
                     break;
            case 3:  wS = "Tuesday";
                     break;
            case 4:  wS = "Wednesday";
                     break;
            case 5:  wS = "Thursday";
                     break;
            case 6:  wS = "Friday";
                     break;
            case 7:  wS = "Saturday";
                     break;
            
            default: wS = "Invalid weekday";
                     break;
        }
        return wS;
    }
    
    public String getDateString()
    /*
     * creating string dateStr
     */
    {
       String dateStr = weekString() + ", " + gregDay.get(GregorianCalendar.DAY_OF_MONTH) +", " + monthName() + ", " + gregDay.get(GregorianCalendar.YEAR);
       return dateStr;     
    }
}