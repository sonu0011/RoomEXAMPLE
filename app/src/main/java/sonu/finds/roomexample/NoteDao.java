package sonu.finds.roomexample;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {
    @Insert
    void  insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void  update(Note note);

    @Query("DELETE FROM NOTE_TABLE")
    void  deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY prority desc")
    LiveData<List<Note>> getAllNotes();
}
