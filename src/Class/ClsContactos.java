/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import BD.ClsBD;

public class ClsContactos {
    public int idContacto;
    public String cedula;
    public String nombre;
    public String apellidos;
    public String telefono;
    public String correo;
    
    /*ACTUALIZADO*/
    public boolean ActualizadoDeDatos(int IdParaActualizar, ClsContactos contactoActualizado) {
        // Busca el contacto con el ID proporcionado y actualiza sus datos
        for (int i = 0; i < ClsBD.jsonContactos.size(); i++) {
            ClsContactos contacto = ClsBD.jsonContactos.get(i);
            if (contacto.idContacto == IdParaActualizar) {
                contacto.cedula = contactoActualizado.cedula;
                contacto.nombre = contactoActualizado.nombre;
                contacto.apellidos = contactoActualizado.apellidos;
                contacto.telefono = contactoActualizado.telefono;
                contacto.correo = contactoActualizado.correo;

                // Guarda los cambios en el archivo y vuelve a cargar los datos en memoria
                Gson gson = new Gson();
                String jsonString = gson.toJson(ClsBD.jsonContactos);

                try {
                    FileWriter fileWriter = new FileWriter("contactos.txt");
                    fileWriter.write(jsonString);
                    fileWriter.close();
                    ObtenerDatosMemoria();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

                return true;
            }
        }

        // Si no se encuentra el contacto con el ID proporcionado, devuelve false
        return false;
    }
    
    /*GUARDADO*/
    public boolean GuardarDatosMemoria() {
        Gson gson = new Gson();
        String jsonString = gson.toJson(ClsBD.jsonContactos);

        try {
            FileWriter fileWriter = new FileWriter("contactos.txt");
            fileWriter.write(jsonString);
            fileWriter.close();
            ObtenerDatosMemoria();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*OBTENER DATOS DEL ARCHIVO TXT*/
    public void ObtenerDatosMemoria() {
        try {
            FileReader reader = new FileReader("contactos.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            StringBuilder result = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }

            reader.close();  
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<ClsContactos>>(){}.getType();
            ArrayList<ClsContactos> listaGuardada = gson.fromJson(result.toString(), listType);
            ClsBD.jsonContactos = listaGuardada;

        } catch (IOException e) {
            
        }
    }
}



