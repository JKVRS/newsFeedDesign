package com.development.newsfeed.repository;

import com.development.newsfeed.model.Session;
import com.development.newsfeed.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {

      Session save(Session session);
}
