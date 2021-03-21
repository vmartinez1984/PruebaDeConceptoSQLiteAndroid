package tk.vmartinez84.pruebadeconceptodeusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tk.vmartinez84.pruebadeconceptodeusuarios.dao.ConexionSqliteHelper;

public class MainActivity extends AppCompatActivity {
    Button buttonGoActivityAddUser;
    Button buttonGoActivityGetUser;
    Button buttonGoActivityGetUserBySpinner;
    Button buttonGoActivityGetUserByListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buttonGoActivityAddUser = findViewById(R.id.buttonGoActivityAddUser);
        this.buttonGoActivityGetUser = findViewById(R.id.buttonGoActivityGetUser);
        this.buttonGoActivityGetUserBySpinner = findViewById(R.id.buttonGoActivityGetUserBySpinner);
        this.buttonGoActivityGetUserByListView  = findViewById(R.id.buttonGoActivityGetUserByListView);
    }

    public void buttonGoActivityAddUser_onClick(View view){
        Intent intent = new Intent(MainActivity.this, RegistroDeUsuariosActivity.class);
        startActivity(intent);
    }

    public void buttonGoActivityGetUser_onClick(View view){
        Intent intent = new Intent(MainActivity.this, ConsultaDeUsuarioActivity.class);
        startActivity(intent);
    }

    public void buttonGoActivityGetUserBySpinner_onClick(View view){
        Intent intent = new Intent(MainActivity.this, ConsultaDeUsuarioPorSpinnerActivity.class);
        startActivity(intent);
    }

    public void buttonGoActivityGetUserByListView_onClick(View view){
        Intent intent = new Intent(MainActivity.this, ConsultaDeUsuarioPorListActivity.class);
        startActivity(intent);
    }
}