package com.kmHompage.idolboard.repository;

import com.kmHompage.idolboard.domain.Forum;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ForumRepository extends ReactiveCrudRepository<Forum, String > {
}
