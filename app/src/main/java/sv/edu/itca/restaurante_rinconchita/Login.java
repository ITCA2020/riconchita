package sv.edu.itca.restaurante_rinconchita;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends Activity {
    Button btnIngresar;
    EditText correo, pass;
    TextView registrarse;
    QueryBD admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnIngresar = findViewById(R.id.btnIngresar);
        correo = findViewById(R.id.txtCorreo);
        pass = findViewById(R.id.txtPass);
        registrarse = findViewById(R.id.txtRegistrar);
        admin = new QueryBD(this, "db_carrito", null, 1);

        SQLiteDatabase db  = admin.getWritableDatabase();
        try {
            db.execSQL("CREATE TABLE usuarios (correo varchar(50),pass varchar(20))");
        } catch (SQLException e) {

        }

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correo.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
                    Toast.makeText(Login.this,"Fallo al iniciar sesion", Toast.LENGTH_SHORT).show();
                } else {

                    validarUsuario();
                }
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Login.this, Registro.class);
                startActivity(objIntento);
            }
        });
    }

    private void validarUsuario () {
        if (correo.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
            Toast.makeText(Login.this,"Fallo al iniciar sesion", Toast.LENGTH_SHORT).show();
        } else {
            SQLiteDatabase db  = admin.getWritableDatabase();

            Cursor fila = db.rawQuery("SELECT * FROM usuarios WHERE correo = '"+correo.getText().toString()+"' AND pass = '"+pass.getText().toString()+"'",null);

            if (fila.moveToFirst()){
                Intent objIntento = new Intent(Login.this, Home.class);
                startActivity(objIntento);
            }else {
                Toast.makeText(Login.this,"Usuario invalido", Toast.LENGTH_SHORT).show();
            }

            db.close();
        }
    }

}