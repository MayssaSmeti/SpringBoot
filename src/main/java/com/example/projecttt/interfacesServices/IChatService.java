package com.example.projecttt.interfacesServices;

import com.example.projecttt.entities.Chat;

import java.util.List;

public interface IChatService {

    public List<Chat> retrieveAllChatts();
    public Long findChatIdByExactUserIds(List<Long> userIds);
    public Chat retrieveChat(Long idChat) ;
    public Chat addChat(Chat c) ;
    public Chat updateChat(Chat c) ;
    public void removeChat(Long idChat) ;
    public List<Chat> retriveChatByidUser(Long utilisateur_id) ;
}
