package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Carrito extends AppCompatActivity {
    QueryBD admin;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        admin = new QueryBD(this, "db_carrito", null, 1);

        CargarTabla();
    }

    public void CargarTabla1() {
        SQLiteDatabase db = admin.getWritableDatabase();
        tabla = (TableLayout)findViewById(R.id.tableCarrito);

        Cursor fila = db.rawQuery("SELECT nombre, cantidad, precio FROM carrito", null);

        if (fila != null) {
            fila.moveToFirst();
            do {
                TableRow row = new TableRow(getBaseContext());
                TextView producto, cant, precio;
                producto = new TextView(getBaseContext());
                cant = new TextView(getBaseContext());
                precio = new TextView(getBaseContext());
                producto.setText(fila.getString(fila.getColumnIndex("nombre")));
                cant.setText(fila.getString(fila.getColumnIndex("cantidad")));
                precio.setText(fila.getString(fila.getColumnIndex("precio")));
                row.addView(producto);
                row.addView(cant);
                row.addView(precio);

            } while (fila.moveToNext());
        }
        db.close();
    }

    public void CargarTabla () {
        SQLiteDatabase db = admin.getWritableDatabase();
        tabla=(TableLayout)findViewById(R.id.tableCarrito);

        Cursor data = db.rawQuery("SELECT nombre, cantidad, precio FROM carrito", null);

        data.moveToFirst();
        do {
            View tableRow = LayoutInflater.from(this).inflate(R.layout.activity_carrito,null,false);
            TextView name  = (TextView) tableRow.findViewById(R.id.textView5);
            TextView cant  = (TextView) tableRow.findViewById(R.id.textView6);
            TextView precio  = (TextView) tableRow.findViewById(R.id.textView7);

            name.setText(data.getString(1));
            cant.setText(data.getString(2));
            precio.setText(data.getString(3));
            tabla.addView(tableRow);

        } while (data.moveToNext());
        data.close();
    }
}