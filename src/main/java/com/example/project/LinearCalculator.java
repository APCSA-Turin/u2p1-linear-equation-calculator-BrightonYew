package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1 = 0;
    private int x2 = 0;
    private int y1 = 0;
    private int y2 = 0;
    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        //these use .length instead of a number to include negatives
    String x1temp = coord1.substring(1,coord1.indexOf(",")); // gets rid of the parentheses and stops at the first number
    x1 = Integer.parseInt(x1temp);
    String y1temp = coord1.substring(coord1.indexOf(",") + 1,coord1.length() - 1); //starts at the second number and stops before the parentheses
    y1 = Integer.parseInt(y1temp);
    String x2temp = coord2.substring(1,coord2.indexOf(","));
    x2 = Integer.parseInt(x2temp);
    String y2temp = coord2.substring(coord2.indexOf(",") + 1,coord2.length() - 1);
    y2 = Integer.parseInt(y2temp);
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int x1){this.x1 = x1;}
    public void setY1(int y1){this.y1 = y1;}
    public void setX2(int x2){this.x2 = x2;}
    public void setY2(int y2){this.y2 = y2;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        //this is the commented out method below, but compacted. it uses the pythagorean theorem to find the a length, using the 2 points to calculated the lengths of the legs
        double finaldis = roundedToHundredth(Math.pow(Math.pow((double)x2 - x1,2) + Math.pow((double)y2 - y1,2),0.5));
        return finaldis;
    }

    /*double xdistance = (double)x2 - x1;
    double ydistance = (double)y2 - y1;
    double xsquared = Math.pow(xdistance,2);
    double ysquared = Math.pow(ydistance,2);
    double added = xsquared + ysquared;
    double finaldis = Math.pow(added,0.5);
    finaldis = roundedToHundredth(finaldis);
    return finaldis;*/


    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        // this takes the slope and multiplies it by the value of the first x. This value is how much y has advanced since the yintercept. y1 is subtracted from it to find the y intercept
        double distanceneededtobesubtracted = slope() * x1;
        if (slope() == -999.99) {
            return -999.99;
        } else {
        return roundedToHundredth(y1 - distanceneededtobesubtracted);
        }
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        // This divides the difference in y by the distance of x, which is the classic slope formula. If the denominator is 0, it would be undefined, as you cant divide by 0
        double rise = y2 - y1;
        double run = x2 - x1;
        if (run != 0) {
            return roundedToHundredth(rise / run);
        } else {
            return -999.99;
        }
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99) {
            return "undefined";
        } else if (yInt() == 0.0) {
            //reduces redundancy, taking out values that equal 0
            return "y=" + slope() + "x";
        } else if (slope() == 0) {
            //reduces redundancy, taking out values that equal 0
            return "y=" + yInt();
        } else if (yInt() < 0) {
            // fixes a issue in which when a yintercept is 0, it would print x+-yint
            return "y=" + slope() + "x" + yInt();
        } else {
        return "y=" + slope() + "x+" + yInt();
        }
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        // first multiplies by 100 to make the Math.round to include the hundreths place (now ones place). Then divides by 100 to return to the original state
            return Math.round(x * 100.0) / 100.0;
        }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " ;
        str += equation();
        str += "\nThe slope of this line is: ";
        str += slope();
        str += "\nThe y-intercept of the line is: ";
        str += yInt();
        str += "\nThe distance between the two points is: ";
        str += distance();
 
        return str;
    }


}