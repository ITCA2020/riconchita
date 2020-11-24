package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    CardView btnAlmuerzos, btnDesayunos, btnAperitivos, btnPostres, btnBebidas, btnCarrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAlmuerzos = findViewById(R.id.btnAlmuerzos);
        btnAperitivos = findViewById(R.id.btnAperitivos);
        btnBebidas = findViewById(R.id.btnBebidas);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnDesayunos = findViewById(R.id.btnDesayunos);
        btnPostres = findViewById(R.id.btnPostres);

        btnAlmuerzos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Almuerzos.class);
                startActivity(objIntento);
            }
        });
        btnAperitivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Aperitivos.class);
                startActivity(objIntento);
            }
        });
        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Bebidas.class);
                startActivity(objIntento);
            }
        });
        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Carrito.class);
                startActivity(objIntento);
            }
        });
        btnDesayunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Desayunos.class);
                startActivity(objIntento);
            }
        });
        btnPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(Home.this, Postres.class);
                startActivity(objIntento);
            }
        });
    }

}