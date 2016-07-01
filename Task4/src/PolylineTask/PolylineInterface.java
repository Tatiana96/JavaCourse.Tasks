package PolylineTask;

import java.util.Scanner;

/**
 * Created by Tatiana on 15.04.2016.
 */
public class PolylineInterface {

    private Polyline polylineInstance = null;

    public void ShowPolylineMenu() {

        while(true) {

            int choice = 0;
            System.out.println("\nPolyline menu\n");
            System.out.println("1 - Create new polyline");
            System.out.println("2 - Show the points of polyline");
            System.out.println("3 - Add a point to the polyline");
            System.out.println("4 - Show the sum length of polyline's segments");
            System.out.println("5 - Find the points in the polyline");
            System.out.println("6 - Exit\n");
            System.out.print("Please, choose any action and input a number: ");

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    createPolyline();
                    break;
                case 2:
                    showPolyline();
                    break;
                case 3:
                    addPoint();
                    break;
                case 4:
                    showLengthPolyline();
                    break;
                case 5:
                    findPoint();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    break;

            }
        }

    } // show the menu for polyline

    public Point createPoint(int index) {
        double x, y;
        if (index == -1)
            System.out.println("Please, input the point you would like to find: ");
        else
            System.out.println("\nPlease, input the point "+index);
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        x = in.nextInt();
        System.out.print("y = ");
        y = in.nextInt();

        Point pointInstance = new Point(x, y);
        return pointInstance;
    } // create a point

    public void createPolyline() {

        int size = 0;
        Scanner in = new Scanner(System.in);
        while (size <= 0) {
            System.out.print("\nInput the amount of points you would like to add: ");
            size = in.nextInt();
        }

        Point[] points = new Point[size];

        for(int i = 0; i < size ; i++)
            points[i] = createPoint(i);

        this.polylineInstance = new Polyline(points);
        System.out.println("Polyline's created successfully...\n");
    } // create a polyline

    public void showPolyline() {
        if (this.polylineInstance == null) {
            System.out.println("Please, create polyline at first...\n");
        }
        else {
            String strPolyline;
            strPolyline = this.polylineInstance.toString();
            System.out.println("Polyline: \n" + strPolyline + "\n");
        }
    } // show a polyline's information

    public void addPoint() {
        if (this.polylineInstance == null) {
            System.out.println("Please, create polyline at first...\n");
        }
        else {
            Point pointInstance = createPoint(this.polylineInstance.getAmountPoints());
            this.polylineInstance.addPoint(pointInstance);
            System.out.println("Point's added successfully...\n");
        }
    } // add a point to polyline

    public void showLengthPolyline() {
        if (this.polylineInstance == null) {
            System.out.println("Please, create polyline at first...\n");
        }
        else {
            double[] lengthSegments;
            double lengthPolyline = 0;

            if (this.polylineInstance.calculateLengthSegments() == null)
                System.out.println("Can't calculate a length. Please, add another point...\n");
            else {
                lengthSegments = this.polylineInstance.calculateLengthSegments().clone();

                System.out.println("The length of polyline: ");

                for (int i = 0; i < lengthSegments.length; i++) {
                    System.out.print(lengthSegments[i]);

                    if (i != lengthSegments.length - 1)
                        System.out.print(" + ");
                    else
                        System.out.print(" = ");

                    lengthPolyline += lengthSegments[i];
                } // for(int i = 0; i < lengthSegments.length; i++)

                System.out.print(lengthPolyline);
            } // else ...

        } // else ...

    } // show the sum length of polyline's segments

    public void findPoint() {
        if (this.polylineInstance == null) {
            System.out.println("Please, create polyline at first...\n");
        }
        else {
            int[] detectedPoints;
            Point pointInstance = createPoint(-1);

            if (this.polylineInstance.findPoints(pointInstance) == null)
                System.out.println("This point's not found. Try again..\n");
            else {
                detectedPoints = this.polylineInstance.findPoints(pointInstance).clone();
                System.out.println("This points's found in indices: \n");

                for (int i = 0; i < detectedPoints.length; i++) {
                    System.out.print(detectedPoints[i]);

                    if (i != detectedPoints.length - 1)
                        System.out.print(" , ");
                    else
                        System.out.print(" ;\n");
                } // for (int i = 0; i < detectedPoints.length; i++)

            } // else ...

        } // else ...

    } // find the points in polyline

    public void exit() {

        int exit;
        System.out.println("Would you like exit? (1/0): \n");
        Scanner in = new Scanner(System.in);
        exit = in.nextInt();

        if (exit == 1) {
            System.exit(0);
        }
    } // function for exit

}
