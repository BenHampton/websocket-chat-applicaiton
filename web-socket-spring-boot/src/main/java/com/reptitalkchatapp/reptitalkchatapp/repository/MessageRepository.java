package com.reptitalkchatapp.reptitalkchatapp.repository;

import com.reptitalkchatapp.reptitalkchatapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
