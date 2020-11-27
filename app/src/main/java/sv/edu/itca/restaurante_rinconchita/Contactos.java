package sv.edu.itca.restaurante_rinconchita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;

public class Contactos extends AppCompatActivity {
    CardView wsp, tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        wsp = findViewById(R.id.wsp);
        tel = findViewById(R.id.tel);


        wsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnviarWsp();
            }
        });
    }

    public void EnviarWsp(){
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("50376305561")+"@s.whatsapp.net");
        startActivity(_intencion);
    }
}