package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import.java.util.*;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "p3Praxedes";
    }

    @Override
    public String getBotToken() {
        return "7022870326:AAE5PRhmAmIGBw2a9atP8ZRQ7LeEOxWi6a8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        //.out.println(update);
        var usuario = update.getMessage().getFrom();
        var mensaje = update.getMessage().getText();
        var id = usuario.getId()
        System.out.println(usuario.getFirstName()+ usuario.getId());

    }
    public void sendText(Long who, String what){
//        SendMessage sm = new SendMessage.builder()
//                .chatId(who.toString())
//                .text(what).build();
//                try{
//                    execute(sm);
//                    catch(TelegramApiException e){
//                        throw new RuntimeException(e);
//                    }
//                }
        public void sendText(Long who, String what){
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
