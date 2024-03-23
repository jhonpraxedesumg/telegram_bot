package org.example;

import org.example.datos.ClsDatosManager;
import org.example.datos.mdUsuario;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {


    private List<mdUsuario> UsuariosRegistrado = new ClsDatosManager().cargarDatosTest();
    private ClsDatosManager datosManager = new ClsDatosManager();
    @Override
    public String getBotUsername() {
        return "p3Praxedes";
    }

    @Override
    public String getBotToken() {
        return "7022870326:AAE5PRhmAmIGBw2a9atP8ZRQ7LeEOxWi6a8";
    }

    @Override
//    public void onUpdateReceived(Update update) {
//        //.out.println(update);
//        var usuario = update.getMessage().getFrom();
//        var mensaje = update.getMessage().getText();
//        var id = usuario.getId();
////        System.out.println(usuario.getFirstName()+ usuario.getId());
//        mensajes.add(usuario + ":" + mensaje);
//
//        System.out.println("id:" + usuario.getId() + "  nombre:" + usuario.getFirstName() + " " +
//                usuario.getLastName() + " escribió: " + mensaje);
//
//
//        if (mensaje.contains("/desplegar") && mensajes.size() > 0) {
//            String lista = "";
//            for (String mensaje1 : mensajes) {
//                lista += mensaje1 + "\n";
//            }
//            sendText(id, lista);
//
//        }
//        //public void sendText(Long who, String what){
////        SendMessage sm = new SendMessage.builder()
////                .chatId(who.toString())
////                .text(what).build();
////                try{
////                    execute(sm);
////                    catch(TelegramApiException e){
////                        throw new RuntimeException(e);
////                    }
////                }


    //CODIGO DEL INGENIERO

    public void onUpdateReceived(Update update) {

//capturar el mensaje
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();


        //obtenemos el chatid
        long chatId = msg.getChatId();
//verifica si existe el usuario en la lista de usuarios
        if (datosManager.buscarUsuarioPorId(id, UsuariosRegistrado) == null) {
            System.out.println("Usuario nuevo");
            //si no existe, se agrega a la lista
            mdUsuario usuario = new mdUsuario();
            usuario.setId(id);
            usuario.setNombre(user.getFirstName());
            usuario.setCorreo("Pendiente");
            sendText(id, "Hola, Eres nuevo por aquí\n ya te agregué a mi lista de usuarios\nPor favor, dime tu correo electrónico");

            UsuariosRegistrado.add(usuario); //agregar a la lista de usuarios


        } else {
            sendText(id, "Hola, ya te conozco");
        }


//fin new
        System.out.println(id+" "+user.getFirstName() + " Escribió: " + msg.getText());



        if (msg.getText().contains("/usuarios")&& UsuariosRegistrado.size() > 0){
            String lista = "";
            for (mdUsuario usr : UsuariosRegistrado) {
                lista += usr.getNombre() +" Correo:"+usr.getCorreo()+ "\n";
                // sendText(id, mensaje);
            }
            sendText(id, lista);


        }

    }
        public void sendText (Long who, String what){
            SendMessage sm = SendMessage.builder()
                    .chatId(who.toString()) //Who are we sending a message to
                    .text(what).build();    //Message content
            try {
                execute(sm);                        //Actually sending the message
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);      //Any error will be printed here
            }
        }
    }
}



