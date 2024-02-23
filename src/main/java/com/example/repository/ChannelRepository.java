package com.example.repository;

import com.example.entity.ChannelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChannelRepository extends CrudRepository<ChannelEntity, Integer>, PagingAndSortingRepository<ChannelEntity, Integer> {
    List<ChannelEntity> findByProfileIdAndVisible(Integer profileId, Boolean visible);

}
