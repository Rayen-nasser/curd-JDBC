import java.util.Date;

public class Step {
    private String title, description, example;
    private Date date;
    private int id;
    public Step(String t, String desc,String e, Date d){
        this.title = t;
        this.description = desc;
        this.example = e;
        this.date = d;
    }

    public Step(int id,String t, String desc,String e, Date d){
        this.id = id;
        this.title = t;
        this.description = desc;
        this.example = e;
        this.date = d;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getExample() {
        return example;
    }

    public int getId() {
        return id;
    }
}
