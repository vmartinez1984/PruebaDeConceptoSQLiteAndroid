package tk.vmartinez84.pruebadeconceptodeusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import tk.vmartinez84.pruebadeconceptodeusuarios.dao.UsuarioDao;
import tk.vmartinez84.pruebadeconceptodeusuarios.entidades.Usuario;

public class ConsultaDeUsuarioPorSpinnerActivity extends AppCompatActivity {
    Spinner spinnerDeUsuarios;
    TextView textViewUsuarioId;
    TextView textViewUsuarioNombre;
    TextView textViewUsuarioTelefono;
    ArrayList<Usuario> listaDeUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_de_usuario_por_spinner);
        this.spinnerDeUsuarios = findViewById(R.id.spinnerDeUsuarios);
        this.textViewUsuarioId = findViewById(R.id.textViewUsuarioId);
        this.textViewUsuarioNombre = findViewById(R.id.textViewUsuarioNombre);
        this.textViewUsuarioTelefono = findViewById(R.id.textViewUsuarioTelefono);
        UsuarioDao usuarioDao;
        ArrayAdapter<Usuario> arrayAdapter;

        usuarioDao = new UsuarioDao(this);
        this.listaDeUsuarios = usuarioDao.getAll();
        this.listaDeUsuarios.add(0, new Usuario(0, "Seleccione", ""));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.listaDeUsuarios);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerDeUsuarios.setAdapter(arrayAdapter);
        this.spinnerDeUsuarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Usuario usuario;

                usuario = (Usuario) adapterView.getItemAtPosition(position);
                if (usuario.getId() == 0) {
                    textViewUsuarioId.setText("");
                    textViewUsuarioNombre.setText("");
                    textViewUsuarioTelefono.setText("");
                } else {
                    textViewUsuarioId.setText("Id :" + usuario.getId());
                    textViewUsuarioNombre.setText("Nombre :" + usuario.getNombre());
                    textViewUsuarioTelefono.setText("Teléfono :" + usuario.getTelefono());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}