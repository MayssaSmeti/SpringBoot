package com.example.projecttt.services;

import com.example.projecttt.entities.Message;
import com.example.projecttt.entities.Utilisateur;
import com.example.projecttt.interfacesServices.IMessageService;
import com.example.projecttt.repositories.MessageRepo;
import com.example.projecttt.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService  implements IMessageService {
      @Autowired
     private   MessageRepo messageRepo;
      @Autowired
      private UtilisateurRepo utilisateurRepo;


    @Override
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    @Override
    public Optional<Message> getMessageById(Long idMessge) {
        return messageRepo.findById(idMessge);
    }

    @Override
    public Message retrieveChat(Long idChat) {
      return   messageRepo.findById(idChat).get();
    }

    @Override
    public Message AddMessage(Message message) {
        message.setEtat(false);
        message.setDateEnvoi(new Date());
        messageRepo.save(message);
        return message;
    }

    @Override
    public void DeleteMessage(Long idMessage) {
        messageRepo.deleteById(idMessage);

    }




    @Override
    public Message UpdateMessage(Message message) {
        message.setEtat(true);
        return messageRepo.save(message);
    }

    @Override
    public List<Message> retriveChatByidChat(Long idChat ){
       return  messageRepo.getChatByChatId(idChat);
    }



    }

