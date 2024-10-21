package com.example.pns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
@Table(name = "messages")
@Getter
@Setter
public class PnsMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public PnsMessage() {
    }

    public PnsMessage(String content, LocalDateTime timeCreate, String userCreated) {
        this.content = content;
        this.timeCreate = timeCreate;
        this.userCreated = userCreated;
    }

    private String content;

    @Override
    public String toString() {
        return content;
    }

    private LocalDateTime timeCreate;

    private String userCreated;
}
