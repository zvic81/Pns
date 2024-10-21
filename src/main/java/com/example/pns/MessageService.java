package com.example.pns;

import com.example.pns.model.PnsMessage;
import com.example.pns.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<PnsMessage> getAllMessages(){
        return messageRepository.findAll();
    }

    public void clearAllMessages(){
        messageRepository.deleteAll();
    }
    public void addMessage(PnsMessage pnsMessage){
        messageRepository.save(pnsMessage);
    }
}
