package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuPrincipal extends AppCompatActivity {
    TextView btnHome, btnAlmuerzos, btnDesayunos, btnAperitivos, btnPostres, btnBebidas, btnCarrito, btnHistorial, btnCerrarSesion, btnSalir;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnHome = findViewById(R.id.btnHome);
        btnAlmuerzos = findViewById(R.id.btnAlmuerzos);
        btnAperitivos = findViewById(R.id.btnAperitivos);
        btnBebidas = findViewById(R.id.btnBebidas);
        btnCarrito = findViewById(R.id.btnCarrito);
        btnDesayunos = findViewById(R.id.btnDesayunos);
        btnPostres = findViewById(R.id.btnPostres);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnCerrarSesion = findViewById(R.id.btnCerraSesion);
        btnSalir = findViewById(R.id.btnSalir);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Home.class);
                startActivity(objIntento);
            }
        });
        btnAlmuerzos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Almuerzos.class);
                startActivity(objIntento);
            }
        });
        btnAperitivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Aperitivos.class);
                startActivity(objIntento);
            }
        });
        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Bebidas.class);
                startActivity(objIntento);
            }
        });
        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Carrito.class);
                startActivity(objIntento);
            }
        });
        btnDesayunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Desayunos.class);
                startActivity(objIntento);
            }
        });
        btnPostres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Postres.class);
                startActivity(objIntento);
            }
        });
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntento = new Intent(MenuPrincipal.this, Login.class);
                startActivity(objIntento);
                finish();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}