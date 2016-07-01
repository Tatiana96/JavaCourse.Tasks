package PolylineTask;

import java.io.Serializable;

/**
 * Created by Tatiana on 15.04.2016.
 */
public class Polyline implements Serializable {

    private Point[] pointsArray; // list of points
    private double[] lengthSegments = null;

    public Polyline(double[][] coordinates) {
        this.pointsArray = new Point[coordinates.length];  //Array to hold points

        for(int i = 0; i < coordinates.length ; i++)
            this.pointsArray[i] = new Point(coordinates[i][0], coordinates[i][1]); //create points from the coordinates

    } // construct a polyline from an array of coordinate pairs

    public Polyline(Point[] points) {
        //this.pointsArray = new Point[points.length];
        this.pointsArray = points.clone();
    } // construct a polyline from an array of points

    public void expandPolyline() {
        Point[] pointsArrayTmp;
        pointsArrayTmp = new Point[this.pointsArray.length + 1];

        for(int i = 0; i < this.pointsArray.length ; i++)
            pointsArrayTmp[i] = this.pointsArray[i];

        this.pointsArray = pointsArrayTmp.clone();
    } // service function for expanding an array

    public int getAmountPoints() {
        return this.pointsArray.length;
    } // service function for getting of points' amount in polyline

    public void addPoint(Point point) {
        expandPolyline();
        this.pointsArray[this.pointsArray.length - 1] = point;
    } // add a point object to the list

    public void addPoint(double x, double y) {
        expandPolyline();
        this.pointsArray[this.pointsArray.length] = new Point(x, y);
    } // add a point from a coordinate pair to the list

    public Point getPointN(int index) {

        if (index >= this.pointsArray.length)
            return null;

        return this.pointsArray[index];
    } // add a Point object to the list

    public double[] calculateLengthSegments() {

        if (this.pointsArray.length < 2)
            return this.lengthSegments;

        this.lengthSegments = new double[this.pointsArray.length - 1];

        for(int i = 0; i < this.lengthSegments.length ; i++)
            this.lengthSegments[i] = pointsArray[i].findDistance(pointsArray[i+1]);

        return lengthSegments;
    } // calculate length of polyline's segments

    public int[] findPoints(double x, double y) {

        Point pointReq = new Point(x, y); // required point

        int j = 0;
        int amount = 0;
        int[] requiredPoints = null;

        for(int i = 0; i < this.pointsArray.length ; i++)
            if (this.pointsArray[i].Compare(pointReq))
                amount++;

        if (amount == 0)
            return requiredPoints;

        requiredPoints = new int[amount];

        for(int i = 0; i < this.pointsArray.length ; i++)
            if (this.pointsArray[i].Compare(pointReq)) {
                requiredPoints[j] = i;
                j++;
            }

        return requiredPoints;
    } // find points and return the list of required points' indexes

    public int[] findPoints(Point pointReq) {

        int j = 0;
        int amount = 0;
        int[] requiredPoints = null;

        for(int i = 0; i < this.pointsArray.length ; i++)
            if (this.pointsArray[i].Compare(pointReq))
                amount++;

        if (amount == 0)
            return requiredPoints;

        requiredPoints = new int[amount];

        for(int i = 0; i < this.pointsArray.length ; i++)
            if (this.pointsArray[i].Compare(pointReq)) {
                requiredPoints[j] = i;
                j++;
            }

        return requiredPoints;
    } // find points and return the list of required points' indexes

    public String toString() {
        StringBuffer strPolyline = new StringBuffer("");

        for(int i = 0; i < this.pointsArray.length ; i++) {
            strPolyline.append("("+ this.pointsArray[i].toString()+ ") - "); // Append the current point

        }
        return strPolyline.toString();
    }

}
