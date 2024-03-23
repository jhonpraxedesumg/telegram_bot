package org.example.jsonSample;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClsJson {

//    public String convertirteObjetoJson(Object objeto, String archivo) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        //pasa el  objero a un archivo y guardara
//        mapper.writeValue(new File(archivo),objeto);
//        //pasa el json a un string
//        String jsonInString = mapper.writeValueAsString(objeto);
//        return jsonInString;
//    }
//public Object convertirteJsonObjeto(){
//    ObjectMapper mapper =new ObjectMapper();
//    Object objArchivo = new Object();
//    try {
//        objArchivo = mapper.readValue()
//    }
//}
//lee un archivo json y lo pone en un objeto de type arraylist
public ArrayList<mdBot> convierteJsonAObjeto() {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<mdBot> listaObjetos = new ArrayList<>();

    try {
        //JSON de archivo a objeto
        listaObjetos = mapper.readValue(new File("C:\\tmp\\fuentes\\file.json"), new TypeReference<ArrayList<mdBot>>(){});
    } catch (Exception ex) {
        Logger.getLogger(ClsJson.class.getName()).log(Level.SEVERE, null, ex);
    }
    return listaObjetos;
}


    //graba en un archivo json un objeto de tipo arraylist
    public String convierteObjetoJson(ArrayList<mdBot> listaObjetos) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Pasa el objeto a un archivo y lo guarda
        mapper.writeValue(new File("C:\\tmp\\fuentes\\file.json"), listaObjetos);
        //pasa el json a un string
        String jsonInString = mapper.writeValueAsString(listaObjetos);
        return jsonInString;
    }



    public static void main(String[] args) {
        ClsJson objJson = new ClsJson();
        mdBot botData = new mdBot();

        botData = (mdBot) objJson.convertirteJsonObjeto();
        System.out.println("nombre="+ botData.getNombre());

//        botData.setNombre("SERGUIO");
//        botData.setMensaje("hola");
//        botData.setId(12345678L);
//
//
//        try{
//            System.out.println(objJson.convertirteObjetoJson(botData, "c//TMP"));
//        }catch(Exception ex){
//            System.out.println("hubo un problema ");
//
//        }


    }
}
