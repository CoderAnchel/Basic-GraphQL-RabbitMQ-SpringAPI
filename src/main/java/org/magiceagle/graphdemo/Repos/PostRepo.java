package org.magiceagle.graphdemo.Repos;

import org.magiceagle.graphdemo.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    // MARKER
}
