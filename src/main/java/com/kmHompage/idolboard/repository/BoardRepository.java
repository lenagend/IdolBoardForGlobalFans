package com.kmHompage.idolboard.repository;

import com.kmHompage.idolboard.domain.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BoardRepository extends ReactiveCrudRepository<Board, String > {
}
