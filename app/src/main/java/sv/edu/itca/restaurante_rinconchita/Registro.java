package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText correo, contra1, contra2;
    Button registrar;
    QueryBD admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        correo = findViewById(R.id.editCorreo);
        contra1 = findViewById(R.id.txtContraRegistrar1);
        contra2 = findViewById(R.id.txtContraRegistrar2);
        registrar = findViewById(R.id.btnRegistrar);
        admin = new QueryBD(this, "db_carrito", null, 1);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarUsuario();
            }
        });

    }

    public void AgregarUsuario(){
        if (correo.getText().toString().isEmpty() || contra1.getText().toString().isEmpty() || contra1.getText().toString().isEmpty()){
            Toast.makeText(Registro.this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else if (!contra1.getText().toString().equals(contra2.getText().toString())) {
            Toast.makeText(Registro.this,"Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db = admin.getWritableDatabase();

            ContentValues datos = new ContentValues();
            datos.put("correo", correo.getText().toString());
            datos.put("pass", contra1.getText().toString());

            db.insert("usuarios", null, datos);
            Toast.makeText(Registro.this,"Usuario resgistrado", Toast.LENGTH_SHORT).show();
            Intent objIntento = new Intent(Registro.this, Home.class);
            startActivity(objIntento);
            db.close();
            finish();
        }
    }
}