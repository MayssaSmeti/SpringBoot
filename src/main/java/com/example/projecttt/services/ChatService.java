package com.example.projecttt.services;

import com.example.projecttt.entities.Chat;
import com.example.projecttt.interfacesServices.IChatService;
import com.example.projecttt.repositories.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {
    @Autowired
    private  ChatRepo chatRepository;

    @Override
    public List<Chat> retrieveAllChatts() {
        return chatRepository.findAll();
    }

    @Override
    public Chat retrieveChat(Long idChat) {
       return  chatRepository.findById(idChat).get();
    }

    @Override
    public Chat addChat(Chat c) {
       c.setVisibility(false);
        return chatRepository.save(c);
    }

    @Override
    public Chat updateChat(Chat c) {
        c.setVisibility(true);
        return chatRepository.save(c);
    }

    @Override
    public void removeChat(Long idChat) {
        chatRepository.deleteById(idChat);

    }

    @Override
    public List<Chat> retriveChatByidUser(Long utilisateur_id) {
        return chatRepository.findByUtilisateurs(utilisateur_id);
    }
}
