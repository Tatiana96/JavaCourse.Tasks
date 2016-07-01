package ExerciseTask;

import java.util.Scanner;

/**
 * Created by Tatiana on 04.05.2016.
 */
public class ExerciseQueue {

    Exercise[] exercisesArray;

    int currentNumber; // the amount of exercise
    int sizeQueue; // size of array

    ExerciseQueue(){
        this.currentNumber = 0;
        this.sizeQueue = 3;
        this.exercisesArray = new Exercise[this.sizeQueue];

    } // construct the queue

    public static Scanner in = new Scanner(System.in);

    public void addExercise() {

        int  priority, workload;
        String textDescription;

        System.out.print("\nPlease, input a priority (0 - maxValue, 10 - minValue) : ");
        priority = in.nextInt();

        System.out.print("\nPlease, input a workload (measured in points): ");
        workload = in.nextInt();

        System.out.print("\nPlease, input the texture description: ");
        textDescription = in.next();

        Exercise exerciseInstance = new Exercise(priority, workload, textDescription);
        exerciseInstance.setId(currentNumber);

        if ( sizeQueue < currentNumber + 1 ) {

            sizeQueue += 5;

            Exercise[] exercisesArrayTmp = new Exercise[sizeQueue];

            for(int i=0; i < currentNumber; i++)
                exercisesArrayTmp[i] = exercisesArray[i];

            exercisesArray = exercisesArrayTmp.clone();
        } // if ...

        if ( currentNumber == 0 )
            exercisesArray[currentNumber] = exerciseInstance;
        else
            this.sortQueue(exerciseInstance, 0, currentNumber - 1); // sorting

        currentNumber++;

    } // adding the exercise

    public void sortQueue(Exercise exerciseInstance, int minValue, int maxValue) {

        if( minValue == maxValue ) {
            
            Exercise[] extraExercise = new Exercise[sizeQueue];

            if( exercisesArray[minValue].priority >= exerciseInstance.priority ) {

                for(int i = 0; i < minValue; i++ )
                    extraExercise[i] = exercisesArray[i];
                
                extraExercise[minValue] = exerciseInstance;

                for(int i = minValue + 1; i <= currentNumber; i++)
                    extraExercise[i] = exercisesArray[i-1];
            } // if ...
            else {
                for(int i=0; i <= minValue; i++ )
                    extraExercise[i] = exercisesArray[i];
                
                extraExercise[minValue + 1] = exerciseInstance;
                
                for(int i = minValue + 2; i <= currentNumber; i++)
                    extraExercise[i] = exercisesArray[i-1];
            } // else ...
            
            exercisesArray = extraExercise;
            return;
            
        } // if ( minValue == maxValue ) ...
        else 
        if ( minValue == maxValue-1 ) {
            Exercise[] extraExercise = new Exercise[sizeQueue];

            if ( exercisesArray[minValue].priority >= exerciseInstance.priority ) {

                for(int i=0; i < minValue; i++ )
                    extraExercise[i] = exercisesArray[i];

                extraExercise[minValue] = exerciseInstance;

                for(int i = minValue+1; i<=currentNumber;i++)
                    extraExercise[i] = exercisesArray[i-1];
            } // if ...
            else {
                if ( exercisesArray[maxValue].priority >= exerciseInstance.priority ) {

                    for(int i=0;  i < maxValue; i++ )
                        extraExercise[i] = exercisesArray[i];

                    extraExercise[maxValue] = exerciseInstance;

                    for(int j = maxValue+1; j<=currentNumber;j++)
                        extraExercise[j] = exercisesArray[j-1];

                } // if...
                else {

                    for(int i=0;  i <= maxValue; i++ )
                        extraExercise[i] = exercisesArray[i];

                    extraExercise[maxValue+1] = exerciseInstance;

                    for(int j = maxValue+2 ; j<=currentNumber;j++)
                        extraExercise[j] = exercisesArray[j-1];
                } // else ...
            } // else ...

            exercisesArray = extraExercise;
            return;
        } // if ( minValue == maxValue-1 )
        if ( exercisesArray[maxValue / 2].priority > exerciseInstance.priority )
            this.sortQueue(exerciseInstance, minValue, maxValue/2-1);
        else
            this.sortQueue(exerciseInstance,  maxValue/2+1, maxValue);
    } // function for sorting the queue

    public Exercise getTopExercise() {
        return this.exercisesArray[0];
    } // get the top object

    public Exercise popExercise () {

        Exercise exerciseTmp = this.exercisesArray[0];
        Exercise[] extraExercise = new Exercise[sizeQueue];

        for(int i = 0; i < currentNumber; i++) {
            extraExercise[i] = this.exercisesArray[i + 1];
        }

        this.exercisesArray = extraExercise;
        return exerciseTmp;

    } // get and delete the top object from the queue

    public Exercise findWorkload( int workload ) {

        int MaxPrior = this.exercisesArray[0].priority;

        int maxWorkload = 0, extraId = 0;
        int i = 0;

        while(this.exercisesArray[i].priority == MaxPrior) {

            if(this.exercisesArray[i].workload >= maxWorkload && this.exercisesArray[i].workload < workload) {
                maxWorkload = this.exercisesArray[i].workload;
                extraId = i;
            } // if ...
            i++;
        } // while
        return this.exercisesArray[extraId];

    } // find the workload

    public Exercise deleteExercise( int id ) {
        Exercise extraExercise = null;

        for(int i = 0; i < exercisesArray.length; i++) {

            if ( exercisesArray[i].getId() == id ) {

                extraExercise = exercisesArray[i];
                Exercise[] exerciseTmp = new Exercise[sizeQueue];

                for(int j=0; j< i; j++)
                    exerciseTmp[j] = exercisesArray[j];

                for(int j=i; j < exercisesArray.length; j++)
                    exerciseTmp[j] = exercisesArray[j+1];

                exercisesArray = exerciseTmp;
            } // if ...
        } // for ...
        return extraExercise;

    } // delete the exercise

    public Exercise findId( int id ) {

        for(int i = 0; i < exercisesArray.length; i++)
            if (exercisesArray[i].getId() == id)
                return exercisesArray[i];

        return null;

    } // find exercise using Id

    public int getSumWorkload() {

        int sumWorkload = 0;

        for(int i=0; i < exercisesArray.length; i++)
            sumWorkload += exercisesArray[i].workload;
        return sumWorkload;

    } // getting the sum workload

    public void deleteAllExercises() {

        for(int i = 0; i < exercisesArray.length; i++) {
            exercisesArray[i]=null;
        }

        currentNumber = 0;
    } // clearing the queue


}
