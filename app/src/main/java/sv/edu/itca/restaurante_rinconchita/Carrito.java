package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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


    public void MostrarMensaje (String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void CargarTabla() {
        SQLiteDatabase db = admin.getWritableDatabase();
        tabla = (TableLayout)findViewById(R.id.tableCarrito);

        Cursor fila = db.rawQuery("SELECT nombre, cantidad, precio FROM carrito", null);

        Integer i = 0;

        if (fila != null) {
            fila.moveToFirst();
            do {
                TableRow row = new TableRow(getBaseContext());
                TextView producto, cant, precio;
                producto = new TextView(getBaseContext());
                cant = new TextView(getBaseContext());
                precio = new TextView(getBaseContext());
                cant.setPadding(35,35,35,35);
                cant.setGravity(Gravity.CENTER);
                producto.setGravity(Gravity.CENTER);
                precio.setGravity(Gravity.CENTER);
                producto.setText(fila.getString(fila.getColumnIndex("nombre")));
                cant.setText(fila.getString(fila.getColumnIndex("cantidad")));
                precio.setText(fila.getString(fila.getColumnIndex("precio")));
                row.addView(cant);
                row.addView(producto);
                row.addView(precio);

                tabla.addView(row);

            } while (fila.moveToNext());
        }
        db.close();
    }

}