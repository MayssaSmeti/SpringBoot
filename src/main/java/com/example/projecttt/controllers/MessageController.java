package com.example.projecttt.controllers;

import com.example.projecttt.entities.Message;
import com.example.projecttt.interfacesServices.IMessageService;
import com.example.projecttt.services.MessageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired

    public MessageController(MessageService mService) {
        this.messageService = mService;
    }

    @GetMapping("/get-by-idChat/{idChat}")
    public List<Message> getAllByIdChat(@PathVariable("idChat") Long idChat) {
        return messageService.retriveChatByidChat(idChat);
    }

    @GetMapping("/Messages")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping("/AddMessage")
    public Message addMessage(@RequestBody Message message) {
        message.setDateEnvoi(new Date());
        messageService.AddMessage(message);
        return message;
    }


    @PutMapping("/update-message")
    public Message updateMessages(@RequestBody Message m) {
        m=messageService.retrieveChat(m.getIdMessage());
        return messageService.UpdateMessage(m);
    }

}
