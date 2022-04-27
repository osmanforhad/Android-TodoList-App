package developer.osmanforhad.todolist;

public class Model {

    //__Define the Variables__//
    private String task, description, id, date;

    //__Null Constructor Method__//
    public Model(){

    }

    //__Parameterized Constructor Method__//
    public Model(String task, String description, String id, String date) {
        this.task = task;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    //__Define Getter and Setter Method all Variables__//
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
