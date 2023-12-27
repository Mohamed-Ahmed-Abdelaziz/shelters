package com.example.shelters.notification;

import com.example.shelters.adopter.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
