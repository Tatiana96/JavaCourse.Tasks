package ExerciseTask;

import java.util.Scanner;

/**
 * Created by Tatiana on 04.05.2016.
 */
public class Interface {

    public static Scanner in = new Scanner(System.in);

    public  static void main(String[] args) {
        System.out.println("Please, input the type of array: ");
        System.out.println("1 - Sortable array");
        System.out.println("2 - BinaryHeap");
        System.out.print("\n ---> ");
        int choice = in.nextInt();

        if (choice == 1)	{
            ExerciseQueue arrayEQ = new ExerciseQueue();
            menuExerciseQueue(arrayEQ);
        }
        else {
            BinaryHeap Array = new BinaryHeap();
            menuBinaryHeap(Array);
        }
        System.out.println("Closing...");

    }

    public static void operateExerciseQueue (ExerciseQueue arrayEQ, int type){
        Exercise extraExercise = null;

        if( type == 1 || type == 2 || type == 3 )
            System.out.println("An exercise with maximal priority");

        switch (type) {
            case 1:
                extraExercise = arrayEQ.getTopExercise();
                break;
            case 2:
                extraExercise = arrayEQ.popExercise();
                break;
            case 3:
                System.out.println("With required workload: ");
                int workload;
                workload = in.nextInt();
                extraExercise = arrayEQ.findWorkload(workload);
                break;
            case 4:
                System.out.println("Please, input the id of exercise you would like to delete: ");
                int idDelete = in.nextInt();
                extraExercise = arrayEQ.deleteExercise(idDelete);
                break;
            case 5:
                System.out.println("Please, input the id of exercise you would like to find: ");
                int idFind = in.nextInt();
                extraExercise = arrayEQ.findId(idFind);
                break;
        }

        System.out.println("-- Exercise information --");
        System.out.println("Id exercise: " + extraExercise.getId());
        System.out.println("Priority: " + extraExercise.getPriority());
        System.out.println("Workload: " + extraExercise.getWorkload());
        System.out.println("Texture description: " + extraExercise.getTextDescription());
    }

    public static void changeExerciseQueue(ExerciseQueue arrayEQ) {

        System.out.println("Please, input the id of exercise for changing the priority: ");
        int id = in.nextInt();

        System.out.println("Input the new priority: ");
        int newPriority = in.nextInt();
        Exercise extraExercise = arrayEQ.findId(id);
        extraExercise.setPriority(newPriority);
    }

    public static void showAllExercises(ExerciseQueue arrayEQ) {

        for (int i = 0; i < arrayEQ.currentNumber; i++) {
            System.out.println("Id exercise: " + arrayEQ.exercisesArray[i].getId());
            System.out.println("Priority: " + arrayEQ.exercisesArray[i].getPriority());
            System.out.println("Workload: " + arrayEQ.exercisesArray[i].getWorkload());
            System.out.println("Texture description: " + arrayEQ.exercisesArray[i].getTextDescription());
            System.out.println();
        } // for ...
    }



    public static void menuExerciseQueue( ExerciseQueue arrayEQ ) {

        int choice;
        boolean work = true;

        while (work) {
            System.out.println();
            System.out.println("Please, choose an action: ");
            System.out.println("1 - Add an exercise;");
            System.out.println("2 - Get an exercise with maximal priority without deleting (Top); ");
            System.out.println("3 - Pop an exercise with maximal priority; ");
            System.out.println("4 - Pop an exercise with maximal priority and required workload; ");
            System.out.println("5 - Delete an exercise using Id;");
            System.out.println("6 - Get an exercise using Id; ");
            System.out.println("7 - Change the priority of exercise using Id; ");
            System.out.println("8 - Calculate the sum workload of exercises; ");
            System.out.println("9 - Delete all exercises (clearing the queue); ");
            System.out.println("10 - Show all exercises; ");
            System.out.println("0 - Exit; ");
            System.out.print("\n ---> ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    arrayEQ.addExercise();break;
                case 2:
                    operateExerciseQueue(arrayEQ, 1);
                    break;
                case 3:
                    operateExerciseQueue(arrayEQ, 2);
                    break;
                case 4:
                    operateExerciseQueue(arrayEQ, 3);
                    break;
                case 5:
                    operateExerciseQueue(arrayEQ, 4);
                    break;
                case 6:
                    operateExerciseQueue(arrayEQ, 5);
                    break;
                case 7:
                    changeExerciseQueue(arrayEQ);
                    break;
                case 8:
                    System.out.println("The sum workload is " + arrayEQ.getSumWorkload());
                    break;
                case 9:
                    arrayEQ.deleteAllExercises();
                    break;
                case 10:
                    showAllExercises(arrayEQ);
                    break;
                case 0:
                    work = false;
                    break;
            } // switch ...
        } // while ...
    } // menuExerciseQueue ...

    public static void menuBinaryHeap(BinaryHeap arrayBH){

        int choice;
        boolean work = true;

        while (work) {

            System.out.println();
            System.out.println("Please, choose an action: ");
            System.out.println("1 - Add an exercise;");
            System.out.println("2 - Get an exercise with maximal priority without deleting (Top); ");
            System.out.println("3 - Pop an exercise with maximal priority; ");
            System.out.println("4 - Pop an exercise with maximal priority and required workload; ");
            System.out.println("5 - Delete an exercise using Id;");
            System.out.println("6 - Get an exercise using Id; ");
            System.out.println("7 - Change the priority of exercise using Id; ");
            System.out.println("8 - Calculate the sum workload of exercises; ");
            System.out.println("9 - Delete all exercises (clearing the queue); ");
            System.out.println("10 - Show all exercises; ");
            System.out.println("0 - Exit; ");
            System.out.print("\n ---> ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    arrayBH.pushExercise();
                    break;
                case 2:
                    operateBinaryHeap(arrayBH, 1);
                    break;
                case 3:
                    operateBinaryHeap(arrayBH, 2);
                    break;
                case 4:
                    operateBinaryHeap(arrayBH, 3);
                    break;
                case 5:
                    operateBinaryHeap(arrayBH, 4);
                    break;
                case 6:
                    operateBinaryHeap(arrayBH, 5);
                    break;
                case 7:
                    changeBinaryHeap(arrayBH);
                    break;
                case 8:
                    System.out.println("The sum workload is " + arrayBH.getSumWorkload());
                    break;
                case 9:
                    arrayBH.deleteAllExercises();
                    break;
                case 10:
                    showAllBinaryHeap(arrayBH);
                    break;
                case 0:
                    work = false;
                    break;
            } // switch ...
        } // while ...
    } // menuBinaryHeap ...

    public static void operateBinaryHeap(BinaryHeap arrayBH, int type) {
        Exercise extraExercise = null;

        if( type == 1 || type == 2 || type == 3 )
            System.out.println("An exercise with maximal priority");

        switch (type) {
            case 1:
                extraExercise = arrayBH.getTopExercise();
                break;
            case 2:
                extraExercise = arrayBH.popExercise();
                break;
            case 3:
                System.out.println("With required workload: ");
                int workload;
                workload = in.nextInt();
                extraExercise = arrayBH.findWorkload(workload);
                break;
            case 4:
                System.out.println("Please, input the id of exercise you would like to delete: ");
                int idDelete = in.nextInt();
                extraExercise = arrayBH.deleteExercise(idDelete);
                break;
            case 5:
                System.out.println("Please, input the id of exercise you would like to find: ");
                int idFind = in.nextInt();
                extraExercise = arrayBH.findId(idFind);
                break;
        } // switch ...

        System.out.println("-- Exercise information --");
        System.out.println("Id exercise: " + extraExercise.getId());
        System.out.println("Priority: " + extraExercise.getPriority());
        System.out.println("Workload: " + extraExercise.getWorkload());
        System.out.println("Texture description: " + extraExercise.getTextDescription());

    } // operateBinaryHeap

    public static void changeBinaryHeap(BinaryHeap arrayBH) {

        System.out.println("Please, input the id of exercise for changing the priority: ");
        int id =in.nextInt();

        System.out.println("Input the new priority: ");
        int newPriority =in.nextInt();
        Exercise extraExercise = arrayBH.findId(id);
        extraExercise.setPriority(newPriority);

    } // changeBinaryHeap

    public static void showAllBinaryHeap(BinaryHeap arrayBH){

        for ( int i = 0; i < arrayBH.pointerLastElement; i++ ) {
            System.out.println("Id exercise: " + arrayBH.dataExercise[i].getId());
            System.out.println("Priority: " + arrayBH.dataExercise[i].getPriority());
            System.out.println("Workload: " + arrayBH.dataExercise[i].getWorkload());
            System.out.println("Texture description: " + arrayBH.dataExercise[i].getTextDescription());
            System.out.println();
        } // for ...
    } // showAllBinaryHeap ...

}
