package tk.vmartinez84.pruebadeconceptodeusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tk.vmartinez84.pruebadeconceptodeusuarios.dao.UsuarioDao;
import tk.vmartinez84.pruebadeconceptodeusuarios.entidades.Usuario;

public class ConsultaDeUsuarioActivity extends AppCompatActivity {
    EditText editTextUsuarioId;
    EditText editTextUsuarioNombre;
    EditText editTextUsuarioTelefono;
    Button buttonGetUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_de_usuario);
        this.editTextUsuarioId = findViewById(R.id.editTextUsuarioId);
        this.editTextUsuarioNombre = findViewById(R.id.editTextUsuarioNombre);
        this.editTextUsuarioTelefono = findViewById(R.id.editTextUsuarioTelefono);
        this.buttonGetUsuario = findViewById(R.id.buttonGetUser);
    }

    public void buttonGetUser_onClick(View view){
        Usuario usuario;
        UsuarioDao usuarioDao;
        int id;

        id = Integer.parseInt(this.editTextUsuarioId.getText().toString());
        usuarioDao = new UsuarioDao(this);
        usuario = usuarioDao.get(id);
        if(usuario == null){
            Toast.makeText(this, "No existe el usuario", Toast.LENGTH_LONG).show();
        }else {
            this.editTextUsuarioNombre.setText(usuario.getNombre());
            this.editTextUsuarioTelefono.setText(usuario.getTelefono());
        }
    }
}