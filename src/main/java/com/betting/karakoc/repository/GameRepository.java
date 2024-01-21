package com.betting.karakoc.repository;

import com.betting.karakoc.model.real.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
    List<GameEntity> findAllByBetroundId(Long betroundId);
}
