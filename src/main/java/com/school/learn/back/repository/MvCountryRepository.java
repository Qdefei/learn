package com.school.learn.back.repository;

import com.school.learn.back.entity.MvCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author:gdf
 * @date: 2019/7/29
 * @version: 1.0
 */
public interface MvCountryRepository extends JpaRepository<MvCountry,String> {
    MvCountry findBySid(String id);
    List<MvCountry> findBySnameLike(String sname);
    @Transactional
    @Modifying
    @Query(value = "update mv_country m set m.sname=:name,m.smv=:mv,m.sdesc=:desc,m.sexpired=:expired,m.slastupdate=:lastupdate,m.slastupdateby=:lastupdateby where m.sid= :sid",nativeQuery = true)
    void update(@Param("sid") String sid, @Param("name") String name, @Param("mv") String mv,@Param("desc") String desc, @Param("expired") String expired, @Param("lastupdate") String lastupdate, @Param("lastupdateby") String lastupdateby);
}
