package com.example.demo.repository;

import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.Notification;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationUpdateDao extends CrudRepository<Notification, Long> {







        @Modifying
        @Transactional
        @Query("UPDATE Notification e SET e.viewed=?1 WHERE  e.Id= ?2 ")
        public void updateNotif(boolean viewed, long id);
    }


