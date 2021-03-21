package tk.vmartinez84.pruebadeconceptodeusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tk.vmartinez84.pruebadeconceptodeusuarios.dao.ConexionSqliteHelper;
import tk.vmartinez84.pruebadeconceptodeusuarios.dao.TablaUsuario;
import tk.vmartinez84.pruebadeconceptodeusuarios.dao.UsuarioDao;
import tk.vmartinez84.pruebadeconceptodeusuarios.entidades.Usuario;

public class RegistroDeUsuariosActivity extends AppCompatActivity {
    Button buttonGuardar;
    EditText editTextPersonName;
    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_usuarios);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        editTextPersonName = findViewById(R.id.editTexPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
    }

    public void buttonGuardar_onClick(View view){
        Usuario usuario;
        UsuarioDao usuarioDao;
        Long id;

        usuario = new Usuario();
        usuario.setNombre(editTextPersonName.getText().toString());
        usuario.setTelefono(editTextPhone.getText().toString());
        usuarioDao= new UsuarioDao(this);
        id = usuarioDao.add(usuario);

        Toast.makeText(this, "Id : "+id, Toast.LENGTH_LONG).show();
        /*
        ConexionSqliteHelper conexionSqliteHelper = new ConexionSqliteHelper(this,"db",null, 1);
        SQLiteDatabase database = conexionSqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TablaUsuario.NOMBRE, usuario.getNombre());
        contentValues.put(TablaUsuario.TELEFONO, usuario.getTelefono());

        Long idResultante = database.insert("usuarios",null,contentValues);
        Toast.makeText(this, "Id : "+idResultante, Toast.LENGTH_SHORT).show();
        database.close();
        */
    }
}