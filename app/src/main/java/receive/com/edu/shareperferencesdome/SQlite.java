package receive.com.edu.shareperferencesdome;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQlite extends SQLiteOpenHelper {

//    private static final String CREATE_User ="create tabel user("+ "id integer primary key autoincrement, "+)"
//    public SQlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }

    private static SQLiteDatabase db;
    public SQlite(Context context){
        super(context,"db_test",null,1);
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");db.execSQL("CREATE TABLE IF NOT EXISTS user(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int odlVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);

    }
    public static void add(String name, String password){
        db.execSQL("INSERT INTO user (name,password) VALUES(?,?)",new Object[]{name,password});
    }
    public void delete(String name,String password){
        db.execSQL("DELETE FROM user WHERE name = AND password ="+name+password);
    }
    public void updata(String password){
        db.execSQL("UPDATE user SET password = ?",new Object[]{password});
    }
    public boolean login(){
        String sql1 = "select * from user where name=? and password=?";
        return true;

    }


    public static ArrayList<user> getAllData() {
        ArrayList<user> list = new ArrayList<user>();
        Cursor cursor =db.query("user",null,null,null,null,null,"name DESC");
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            list.add(new user(name,password));
        }
        return list;

    }
}
