package com.acme.nutrimove.messagebroker.infrastructure;

import com.acme.nutrimove.messagebroker.domain.StoredNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredNotificationRepository extends JpaRepository<StoredNotification, Long> {
}
