package ExerciseTask;

/**
 * Created by Tatiana on 04.05.2016.
 */
public class Exercise {

    int id;
    int priority;
    int workload; // measured in points
    String textDescription;

    Exercise() {
        this(0, 0, "Test exercise");
    }

    Exercise(int priority, int workload, String textDescription){
        this.priority = priority;
        this.workload = workload;
        this.textDescription = textDescription;
    }

    void setId(int id) {
        this.id = id;
    }

    int getId() {
        return this.id;
    }

    int getPriority() {
        return this.priority;
    }

    void setPriority(int priority) {
        this.priority = priority;
    }

    int getWorkload() {
        return this.workload;
    }

    void setWorkload(int workload) {
        this.workload = workload;
    }

    String getTextDescription() {
        return this.textDescription;
    }

    void setDescription(String textDescription) {
        this.textDescription = textDescription;
    }

}
