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
    public String idContacto;
    public String cedula;
    public String nombre;
    public String apellidos;
    public String telefono;
    public String correo;

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
            e.printStackTrace();
        }
    }
}



