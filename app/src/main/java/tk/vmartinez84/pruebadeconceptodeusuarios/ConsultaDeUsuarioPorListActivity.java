package tk.vmartinez84.pruebadeconceptodeusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tk.vmartinez84.pruebadeconceptodeusuarios.dao.UsuarioDao;
import tk.vmartinez84.pruebadeconceptodeusuarios.entidades.Usuario;

public class ConsultaDeUsuarioPorListActivity extends AppCompatActivity {
    ListView listViewDeUsuarios;
    ArrayList<Usuario> listaDeUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_de_usuario_por_list);
        listViewDeUsuarios = findViewById(R.id.listViewDeUsuarios);
        UsuarioDao usuarioDao;
        ArrayAdapter<Usuario> arrayAdapter;

        usuarioDao = new UsuarioDao(this);
        this.listaDeUsuarios = usuarioDao.getAll();
        //this.listaDeUsuarios.add(0, new Usuario(0, "Seleccione", ""));
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, this.listaDeUsuarios);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.listViewDeUsuarios.setAdapter(arrayAdapter);
        this.listViewDeUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Usuario usuario;

                usuario = (Usuario) adapterView.getItemAtPosition(position);
                if (usuario.getId() == 0) {

                } else {
                    String data;

                    data = "Id :" + usuario.getId() + "\n";
                    data += "Nombre :" + usuario.getNombre() + "\n";
                    data += "Teléfono :" + usuario.getTelefono();

                    Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}