package sv.edu.itca.restaurante_rinconchita;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QueryBD extends SQLiteOpenHelper {

    public QueryBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE carrito (nombre text, cantidad text, precio text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int v1, int v2) {

    }
}
