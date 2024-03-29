package com.betting.karakoc.repository;

import com.betting.karakoc.models.real.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<GameEntity, String> {
    List<GameEntity> findAllByBetroundId(String betroundId);
}
