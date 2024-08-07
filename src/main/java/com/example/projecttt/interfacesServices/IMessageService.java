package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Commentaire;
import com.example.projecttt.entities.Message;

import java.util.List;
import java.util.Optional;

public interface IMessageService {
    public List<Message> getAllMessages();
    public Optional<Message> getMessageById(Long idMessge) ;
    public Message retrieveChat(Long idChat);
    public Message AddMessage(Message message);
    public void  DeleteMessage(Long idMessage);
    public Message UpdateMessage(Message message);
    public List<Message> retriveChatByidChat(Long  idChat);
}
