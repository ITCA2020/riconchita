package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Almuerzos extends AppCompatActivity {
    ImageView btnMenu, btnAddCarrito1, btnAddCarrito2, btnAddCarrito3, btnAddCarrito4, btnAddCarrito5;
    EditText cantidad;
    TextView nombre, precio;
    Float costo;
    QueryBD admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzos);

        btnMenu = findViewById(R.id.btnMenu);
        btnAddCarrito1 = findViewById(R.id.btnAdd1);
        btnAddCarrito2 = findViewById(R.id.btnAdd2);
        btnAddCarrito3 = findViewById(R.id.btnAdd3);
        btnAddCarrito4 = findViewById(R.id.btnAdd4);
        btnAddCarrito5 = findViewById(R.id.btnAdd5);
        admin = new QueryBD(this, "db_carrito", null, 1);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Almuerzos.this, MenuPrincipal.class);
                startActivity(objIntento);
            }
        });

        btnAddCarrito1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = findViewById(R.id.almuerzoTitulo1);
                cantidad = findViewById(R.id.almuerzoCant1);
                precio = findViewById(R.id.almuerzoPrecio1);
                if (cantidad.getText().toString().isEmpty()){
                    MostrarMensaje("Debe especificar cantidad");
                } else {
                    costo = Float.parseFloat(cantidad.getText().toString())*Float.parseFloat(precio.getText().toString());
                }

                AgregarCarrito();
            }
        });
        btnAddCarrito2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = findViewById(R.id.almuerzoTitulo2);
                cantidad = findViewById(R.id.almuerzoCant2);
                precio = findViewById(R.id.almuerzoPrecio2);
                if (cantidad.getText().toString().isEmpty()){
                    MostrarMensaje("Debe especificar cantidad");
                } else {
                    costo = Float.parseFloat(cantidad.getText().toString())*Float.parseFloat(precio.getText().toString());
                }

                AgregarCarrito();
            }
        });
    }


    //    ****
    //    metodos
    //    ****
    public void MostrarMensaje (String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void Limpiar(EditText cant){
        cant.setText("");
    }

    public void AgregarCarrito(){
        if (cantidad.getText().toString().isEmpty() || cantidad.getText().toString().equals("0")){
            MostrarMensaje("Especifique cantidad");
        } else {
            SQLiteDatabase db = admin.getWritableDatabase();

            ContentValues datos = new ContentValues();
            datos.put("nombre", nombre.getText().toString());
            datos.put("cantidad", cantidad.getText().toString());
            datos.put("precio", costo.toString());

            db.insert("carrito", null, datos);
            MostrarMensaje("Listo, se ha agregado al carrito!");
            Limpiar(cantidad);

            db.close();
        }
    }
}