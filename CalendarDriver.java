import javax.swing.*;
import java.util.TimeZone;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalendarDriver
{
    public static void main(String[] args)
    /*
     * This is just asking the user if they would like to enter a date into the JOptionPane.
     */
    {
        // declarations and initializations of variables
        System.out.println("\f");
        int x = 1;
        // set up infinite loop, and exit if user doesn't want to try another date
        // if user tries a date, go to method PrevSundayofBirthday()
        while (x == 1) {
            int what = JOptionPane.showConfirmDialog(null, "Would you like to enter a date?", "Try a Date!", JOptionPane.YES_NO_OPTION);

            if (what == JOptionPane.YES_OPTION) {
                
                PrevSundayofBirthday();
            } else {
                return;
            }
            
        }
    } 
    
    
    public static void PrevSundayofBirthday() {
        /*
         * First, we declare the variables for month, day, and year. Then, a JPanel is created so that you can get three inputs in one JOptionPane.
         * Then, they actual JOptionPane is created. 
         * Then, an if statement is set up (if the user hits "ok", then do this). 
         * Inside the if statement, a try-catch pair is set up so that it can check for inputs that aren't integers.
         * Then, after the try-catch pair, it prints the entered date.
         */

        // local variable declarations
        
        int day = 0;
        int month = 0;
        int year = 0;
        
        boolean valid = false;
        
        // setting up custom JPanel
        // JPanel being used so that 3 inputs can be read into JOptionPane
        
        JTextField dField = new JTextField(2);
        JTextField mField = new JTextField(2);
        JTextField yField = new JTextField(4);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Day 1-31:"));
        myPanel.add(dField);
        myPanel.add(new JLabel("Month 1-12:"));
        myPanel.add(mField);
        myPanel.add(new JLabel("Year YYYY:"));
        myPanel.add(yField);

        // JPanel now complete
        
        // read the day, month, and year; check if all inputs are integers
        
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter your Birthday in Integers Only", JOptionPane.OK_CANCEL_OPTION);
                
            
        if (result == JOptionPane.OK_OPTION) {

            // try-catch pair is used to see if the java language throws an exception on non-numeric inputs
            
            try {
                day = Integer.parseInt(dField.getText());
                month = Integer.parseInt(mField.getText());
                year = Integer.parseInt(yField.getText());
            } catch (IllegalArgumentException exc) {
                // display to the user that integers were not used as inputs
                int what = JOptionPane.showConfirmDialog(null, "Try typing Integers", "Integers Only!", JOptionPane.NO_OPTION);
                return;
            }

            // if here, inputs are valid integers; printing them out
            
            System.out.println("Entered Day: " + day);
            System.out.println("Entered Month " + month);
            System.out.println("Entered Year " + year);

            // check if the date is a valid Gregorian date, and if so, proceed to find previous Sunday
            
            checkAndAddDay(day, month - 1, year);

        }

        return;
    }

    public static boolean checkAndAddDay(int day, int month, int year) {
        /*
         * Creating the Gregorian Calendar.
         * Checks for invalid integers, with a try-catch pair, and then checks to see if a valid date was entered.
         * If not, an error message will pop up.
         * It, then uses Gregorian Calendar to print the day of the week that was entered. 
         * The JFrame was set up in the CalendarDriver rather than a separate window maker.
         * Instead of using roll, I used add because it makes the process go much quicker.
         * It then prints all of the valuable information for the Sunday before the user's entered date.
         */
        
        
        GregorianCalendar gC;
        boolean valid = true;

        // create a new instance of a Gregorian Calendar within a try-catch block
        // if invalid integers are typed, the constructor will throw an exception
        
        try {
            gC = new GregorianCalendar(year, month, day);
        } catch (IllegalArgumentException exc) {
            valid = false;
            System.out.println(" In Exception Valid: " + valid);
            return valid;
        }

        // if the constructor altered the date due to invalid inputs, test for it, display error, and exit

        if (year != gC.get(GregorianCalendar.YEAR)) valid = false;
        if (month != gC.get(GregorianCalendar.MONTH)) valid = false;
        if (day != gC.get(GregorianCalendar.DAY_OF_MONTH)) valid = false;

        System.out.println("Valid: " + valid);

        if(valid == false){
            int what = JOptionPane.showConfirmDialog(null, "WhackyDate", "Whackydate", JOptionPane.NO_OPTION);
            return valid;

        }
        
        // if here, valid date was entered; now print the day of week
        
        System.out.println("Day of Week (Entered): " + gC.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println("---------------");
        
        // calculate the previous Sunday
        // uses add instead of roll
        
        WeekFrameComponent wf = new WeekFrameComponent( gC);
        JFrame frame = new JFrame();

        frame.setSize(730, 300);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setTitle(wf.getDateString());
        frame.add( wf );
        frame.setVisible(true);
        frame.setResizable(false);
        
        int daysToShift = -(gC.get(GregorianCalendar.DAY_OF_WEEK) - 1);
        
        gC.add(GregorianCalendar.DAY_OF_MONTH, daysToShift);

        int temp = gC.get(GregorianCalendar.MONTH) + 1;


        // print the Sunday prior to user's birthday
        
        System.out.println(" ");
        System.out.println("Day (Sunday Before):" + gC.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println("Month (Sunday Before):" + temp);
        System.out.println("Year (Sunday Before):" + gC.get(GregorianCalendar.YEAR));
        System.out.println("Day of Week (Sunday Before): " + gC.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println("---------------");

        gC.add(GregorianCalendar.DAY_OF_MONTH, -daysToShift);

        // successful, return, and prompt user to try another date
      

       
        return valid;
    }
    
    
}
       