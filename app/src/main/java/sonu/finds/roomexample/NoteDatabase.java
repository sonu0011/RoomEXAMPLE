package sonu.finds.roomexample;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;


@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDatabase;

    public abstract NoteDao getNoteDao();

    public static synchronized NoteDatabase getInstance(Context context) {

        if (noteDatabase == null) {
            noteDatabase =
                    Room.databaseBuilder(context, NoteDatabase.class, "note_db")
                            .addMigrations()
                            .addCallback(callback)
                            .build();

        }
        return noteDatabase;
    }
    private static  RoomDatabase.Callback callback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new DbInsertAsynckTask(noteDatabase).execute();

        }
    };
    private static class DbInsertAsynckTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao;

        public DbInsertAsynckTask(NoteDatabase database){
            noteDao  = database.getNoteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("title1","decription1",1));
            noteDao.insert(new Note("title2","decription2",2));
            noteDao.insert(new Note("title3","decription3",3));
            return null;
        }
    }
}
