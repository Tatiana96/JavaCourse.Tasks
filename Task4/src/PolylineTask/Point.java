package PolylineTask;

import java.io.Serializable;

/**
 * Created by Tatiana on 15.04.2016.
 */
public class Point implements Serializable {

    // coordinates
    protected double x;
    protected double y;

    public Point () {
        x = 0;
        y = 0;
    } // creating a point on default

    public Point (double xValue, double yValue) {
        x = xValue;
        y = yValue;
    } // creating a point from its coordinates

    public Point (Point point) {
        this.x = point.x;
        this.y = point.y;
    } // creating a point from another point

    public void movePoint (double xValue, double yValue) {
        this.x = xValue;
        this.y = yValue;
    } // moving a point to another point

    public double findDistance (Point point) {
        double distance;
        distance = Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
        return distance;
    } // calculating the distance from current point to required

    public double findDistance () {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    } // calculating the distance from current point to the center

    public String toString() {
        return x + ", " + y;
    } // converting a point to a string

    public boolean Compare(Point point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        else
            return false;
    } // points' comparison

}
