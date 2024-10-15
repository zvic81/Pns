package com.example.pns.repository;

import com.example.pns.model.PnsMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<PnsMessage, Long> {
}
