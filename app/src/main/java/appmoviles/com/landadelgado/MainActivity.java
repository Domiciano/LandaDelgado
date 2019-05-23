package appmoviles.com.landadelgado;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    boolean ishere = false;
    private TextView helow;
    private ProgressDialog progressDialog;
    private Button btn_cargar;
    private boolean esta = false;
    private List<Hash> hashes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_cargar = findViewById(R.id.btn_cargar);
        helow = findViewById(R.id.heloow);

        btn_cargar.setOnClickListener(this);

    }


    public void cargarDatos() {
        String linea;


        new Thread(() -> {
            new ServiceManager.hashGET("000155532f5193ef9de3b24b2c454778", response -> {
                if(!response.equals("null")) {
                    Gson g = new Gson();
                    Hash h = g.fromJson(response, Hash.class);
                    runOnUiThread(() -> {
                        helow.setText(h.getCodigoHash());
                    });
                }else{
                    runOnUiThread(() -> {
                        helow.setText("No existe");
                    });
                }

            });
        }).start();


//        Hash m= new Hash("ea3578474ecf57e480e7915afa7e5006");
//
//        database.getReference().child("Sniff2").child("ea3578474ecf57e480e7915afa7e5006").push().setValue("ea3578474ecf57e480e7915afa7e5006");
//
//
//
//                    mensaje("Se cargaron los datos Exitosamente"+ "ea3578474ecf57e480e7915afa7e5006");
//


//        database.getReference().child("Sniff2").child("57f068bb91713e6e643909ab369f80d6").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                mensaje(dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


//        InputStream file = this.getResources().openRawResource(R.raw.names);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
//        try {
//            linea = reader.readLine();
//            while (linea != null) {
//                Hash hash = new Hash(linea);
//                database.getReference().child("Sniff").child("Hash").child(linea).setValue(hash);
//                linea = reader.readLine();
//            }
//            mensaje("Se cargaron los datos Exitosamente");
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        database.getReference().child("Sniff").child("Hash").setValue("ea3578474ecf57e480e7915afa7e5006");

//
//        database.getReference().child("Hash").child(m.getCodigoHash()).addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
////                for (DataSnapshot hijo : dataSnapshot.getChildren()) {
////
////
////                    Log.v("<<<<<<<", hijo.getValue().toString());
////                }
//                mensaje("el codigo es "+dataSnapshot.getValue(Hash.class).getCodigoHash());
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        //Boorar info///
//        database.getReference().child("Sniff2").removeValue();
//        database.getReference().child("Sniff3").removeValue();
//        mensaje("se borró la información");


    }

//    synchronized void synchron(){
//        myThread myThrea=new myThread();
//        helow.setText(myThrea.hash.getCodigoHash());
//    }


    public void mensaje(final String m) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, m, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (btn_cargar.getId() == v.getId()) {
            cargarDatos();
        }

    }


}




