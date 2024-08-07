package com.example.projecttt.controllers;

import com.example.projecttt.entities.Chat;
import com.example.projecttt.services.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/chat")

public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/addChat")
    public Chat addpublication(@RequestBody Chat c) {
        return chatService.addChat(c);
    }
    @GetMapping("/chats")
    public List<Chat> getChats() {
        return chatService.retrieveAllChatts();
    }

    @GetMapping("/chatsById/{idChat}")
    public Chat getChats(@PathVariable("idChat") Long idChat ){
        return chatService.retrieveChat(idChat);
    }
    @GetMapping("/chatsByIdUser/{utilisateur_id}")
    public List<Chat> getChatsByUser(@PathVariable("utilisateur_id") Long utilisateur_id) {
        return chatService.retriveChatByidUser(utilisateur_id);
    }

    @PutMapping("/edit-chat")
    public Chat updatepublication(@RequestBody Chat c) {
        return chatService.updateChat(c);
    }

}
