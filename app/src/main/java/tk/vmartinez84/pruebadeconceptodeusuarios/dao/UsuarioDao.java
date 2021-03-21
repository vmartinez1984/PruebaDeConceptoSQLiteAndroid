package tk.vmartinez84.pruebadeconceptodeusuarios.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import tk.vmartinez84.pruebadeconceptodeusuarios.entidades.Usuario;

public class UsuarioDao {
    private Context context;
    ConexionSqliteHelper conexionSqliteHelper;

    public UsuarioDao(Context context) {
        this.context = context;
        conexionSqliteHelper = new ConexionSqliteHelper(this.context, "db", null, 1);
    }

    public Long add(Usuario usuario) {
        Long idResultante;

        SQLiteDatabase database = conexionSqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TablaUsuario.NOMBRE, usuario.getNombre());
        contentValues.put(TablaUsuario.TELEFONO, usuario.getTelefono());

        //Tambien se puede por hacer por un query
        // String query = "insert into..";
        // database.execSQL(query);

        idResultante = database.insert("usuarios", null, contentValues);
        database.close();

        return idResultante;
    }

    public Usuario get(int usuarioId){
        Usuario usuario;
        SQLiteDatabase database;
        String[] parametros;
        String[] campos;
        Cursor cursor;

        database= conexionSqliteHelper.getReadableDatabase();
        parametros = new String[]{usuarioId+""};
        campos = new String[]{"id", "nombre", "telefono"};
        //Otra opción es:
        //cursor = database.rawQuery("SELECT id, nombre, telefono FROM usuarios WHERE id = ?", parametros);
        cursor = database.query("usuarios",campos,"id = ?",parametros,null, null,null);
        if(cursor.moveToFirst()){
            usuario = getUsuario(cursor);
        }else {
            usuario = null;
        }
        cursor.close();
        database.close();

        return  usuario;
    }

    private Usuario getUsuario(Cursor cursor){
        Usuario usuario;

        usuario = new Usuario();
        usuario.setId(cursor.getInt(0));
        usuario.setNombre(cursor.getString(1));
        usuario.setTelefono(cursor.getString(2));

        return  usuario;
    }
    public ArrayList<Usuario> getAll(){
        ArrayList<Usuario> lista;
        SQLiteDatabase database;
        Cursor cursor;

        database= conexionSqliteHelper.getReadableDatabase();
        cursor = database.rawQuery("SELECT id, nombre, telefono FROM usuarios ", null);

        lista = new ArrayList<>();
        while (cursor.moveToNext()){
            lista.add(getUsuario(cursor));
        }
        cursor.close();
        database.close();

        return  lista;
    }

    public void update(Usuario usuario){
        SQLiteDatabase database;
        String[] parametros;
        ContentValues contentValues;

        parametros = new String[]{usuario.getId()+""};
        contentValues = new ContentValues();
        database = conexionSqliteHelper.getWritableDatabase();
        contentValues.put("nombre",usuario.getNombre());
        contentValues.put("telefono",usuario.getTelefono());
        database.update("usuarios",contentValues,"id = ?",parametros);
        database.close();
    }

    public void delete(int usuarioId){
        SQLiteDatabase database;
        String[] parametros;

        parametros = new String[]{usuarioId+""};
        database = conexionSqliteHelper.getWritableDatabase();

        database.delete("usuarios","id = ?",parametros);
        database.close();
    }
}