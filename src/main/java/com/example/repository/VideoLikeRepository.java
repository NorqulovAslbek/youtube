package com.example.repository;

import com.example.entity.VideoLikeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VideoLikeRepository extends CrudRepository<VideoLikeEntity, Integer> {
    @Query("FROM VideoLikeEntity WHERE videoId=?1 AND profileId=?2")
    Optional<VideoLikeEntity> checkLike(String videoId, Integer profileId);
}
