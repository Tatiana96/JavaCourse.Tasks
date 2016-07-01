package ExerciseTask;

import java.util.Scanner;

/**
 * Created by Tatiana on 04.05.2016.
 */
public class BinaryHeap {

    Exercise[] dataExercise;
    int pointerLastElement = 0;
    int size;
    
    public static Scanner in = new Scanner(System.in);
    
    BinaryHeap() {
        this(3);
    }
    
    BinaryHeap (int size) {
        dataExercise = new Exercise[size];
        this.size = size;
    } // construct

    void swapExercise() {

        if ( pointerLastElement > 2 )
            for(int i = pointerLastElement-1 ; i<2; i--) {
                
                if( (i%2 ==0) && (dataExercise[i].getPriority() < dataExercise[(i-2)/2].getPriority())) {
                    Exercise extraExercise = dataExercise[i];
                    dataExercise[i] = dataExercise[(i-2)/2];
                    dataExercise[(i-2)/2] = extraExercise;
                } // if ...
                else
                if( (i%2 == 1) && dataExercise[i].getPriority() < dataExercise[(i-1)/2].getPriority()) {
                    Exercise extraExercise = dataExercise[i];
                    dataExercise[i] = dataExercise[(i-1)/2];
                    dataExercise[(i-2)/1] = extraExercise;
                } // if ...
                
            } // for ...

        if ( (pointerLastElement>=2) && dataExercise[2].getPriority() < dataExercise[0].getPriority() ) {
            Exercise extraExercise = dataExercise[2];
            dataExercise[2] = dataExercise[0];
            dataExercise[0] = extraExercise;
        }

        if ( (pointerLastElement>=1) && dataExercise[1].getPriority() < dataExercise[0].getPriority() ) {
            Exercise extraExercise = dataExercise[1];
            dataExercise[1] = dataExercise[0];
            dataExercise[0] = extraExercise;
        }

    } // swap the exercise

    void pushExercise() {

        int  priority, workload;
        
        String textDescription;
        
        System.out.print("\nPlease, input a priority (0 - maxValue, 10 - minValue) : ");
        priority = in.nextInt();
        System.out.print("\nPlease, input a workload (measured in points): ");
        workload = in.nextInt();
        System.out.print("\nPlease, input the texture description: ");
        textDescription = in.next();

        Exercise extraExercise = new Exercise(priority, workload, textDescription);
        extraExercise.setId(pointerLastElement);

        if ( size<pointerLastElement + 1 ) {

            size += 3;

            Exercise[] copy = new Exercise[size];

            for ( int i=0; i < pointerLastElement; i++ )
                copy[i] = dataExercise[i];

            dataExercise = copy;

        } // if ...

        dataExercise[pointerLastElement] = extraExercise;

        if ( pointerLastElement != 0 )
            this.swapExercise();

        pointerLastElement++;

    } // push the exercise

    Exercise popExercise() {

        Exercise extraExercise = null;

        if ( pointerLastElement == 0 )
            return extraExercise;

        extraExercise = this.getTopExercise();
        this.getTopExercise().setPriority(11);
        this.swapExercise();
        deleteExercise( extraExercise.getId() );

        return extraExercise;
    }

    Exercise getTopExercise() {
        return this.dataExercise[0];
    }

    Exercise findWorkload (int workload) {

        int maxPriority = this.dataExercise[0].priority;
        int maxWorkload = 0, extraExerciseId = 0;
        int i = 0;

        while(this.dataExercise[i].priority == maxPriority) {

            if ( this.dataExercise[i].workload >= maxWorkload && this.dataExercise[i].workload < workload ) {
                maxWorkload = this.dataExercise[i].workload;
                extraExerciseId = i;
            } // if ...

            i++;
        } // while ...

        return this.dataExercise[extraExerciseId];
    }

    Exercise deleteExercise ( int id ) {

        Exercise extraExercise = findId(id);
        Exercise[] copyExercise = new Exercise[size];

        for ( int i = 0; i < pointerLastElement - 1; i++ ) {

            if(dataExercise[i].getId() != id)
                 copyExercise[i] = dataExercise[i];
            else
                copyExercise[i] = dataExercise[i + 1];

        } // for ...

        dataExercise = copyExercise;
        pointerLastElement--;
        return extraExercise;
    }

    Exercise findId(int id){

        for ( int i = 0; i < pointerLastElement; i++ )
            if (dataExercise[i].getId() == id)
                return dataExercise[i];

        return null;
    }

    int getSumWorkload() {

        int sum = 0;

        for ( int i = 0; i < pointerLastElement; i++ )
            sum += dataExercise[i].getWorkload();

        return sum;
    }

    void deleteAllExercises () {

        for ( int i = 0; i < pointerLastElement; i++ ) {
            dataExercise[i] = null;
        }

        pointerLastElement = 0;

    }
    
}
