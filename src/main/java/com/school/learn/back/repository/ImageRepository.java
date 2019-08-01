package com.school.learn.back.repository;

import com.school.learn.back.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:gdf
 * @date: 2019/7/29
 * @version: 1.0
 */
public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image findBySid(Integer id);
}
