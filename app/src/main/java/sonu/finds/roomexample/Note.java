package sonu.finds.roomexample;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private  String title;
    private String description;
    private int prority;

    public Note(String title, String description, int prority) {
        this.title = title;
        this.description = description;
        this.prority = prority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrority() {
        return prority;
    }
}
