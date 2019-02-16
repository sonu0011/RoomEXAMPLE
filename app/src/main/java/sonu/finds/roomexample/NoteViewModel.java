package sonu.finds.roomexample;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private LiveData<List<Note>> note;
    private NoteRepo noteRepo;

    public NoteViewModel(Application application){
        super(application);

        noteRepo = new NoteRepo(application);
        note = noteRepo.getNoteList();
    }

    void insert(Note note){
        noteRepo.insert(note);
    }

    void update(Note note){
        noteRepo.update(note);
    }

    void delete(Note note){
        noteRepo.delete(note);
    }

    void deleteAllNodes(){
        noteRepo.deleteAllNotes();
    }

    public LiveData<List<Note>> getNote() {
        return note;
    }
}
