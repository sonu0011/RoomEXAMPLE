package sonu.finds.roomexample;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NoteRepo {

    private  NoteDao noteDao;
    private LiveData<List<Note>> noteList;

    public  NoteRepo(Application application){

        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.getNoteDao();
        noteList = noteDao.getAllNotes();
    }

    public  void insert(Note note){
        new InsertAsynckTask(noteDao).execute(note);


    }

    public  void update(Note note){
        new UpdateAsynckTask(noteDao).execute(note);



    }

    public  void delete(Note note){

        new DeleteAsynckTask(noteDao).execute(note);


    }

    public  void deleteAllNotes(){

        new DeleteAllNotesAsynckTask(noteDao).execute();

    }

    public LiveData<List<Note>> getNoteList() {
        return noteList;
    }
    private static class InsertAsynckTask extends AsyncTask<Note,Void,Void>{
      private   NoteDao noteDao;

      private InsertAsynckTask(NoteDao noteDao){
          this.noteDao = noteDao;
      }

        @Override
        protected Void doInBackground(Note... notes) {
          noteDao.insert(notes[0]);

          return null;
        }
    }

    private static class UpdateAsynckTask extends AsyncTask<Note,Void,Void>{
        private   NoteDao noteDao;

        private UpdateAsynckTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);

            return null;
        }
    }

    private static class DeleteAsynckTask extends AsyncTask<Note,Void,Void>{
        private   NoteDao noteDao;

        private DeleteAsynckTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);

            return null;
        }
    }

    private static class DeleteAllNotesAsynckTask extends AsyncTask<Void,Void,Void>{
        private   NoteDao noteDao;

        private DeleteAllNotesAsynckTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();

            return null;
        }
    }
}
