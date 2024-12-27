package org.magiceagle.graphdemo.Repos;

import org.magiceagle.graphdemo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepo extends JpaRepository<User, Long> {
    // marker
}
