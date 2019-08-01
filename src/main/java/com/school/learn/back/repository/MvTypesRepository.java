package com.school.learn.back.repository;

import com.school.learn.back.entity.MvTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface MvTypesRepository extends JpaRepository<MvTypes,String> {

   // public MvTypes findBysid(String id);
    MvTypes findBySid(String sid);

    @Modifying
    @Query(value = "insert into label(sid,sname,sdesc) values(?1,?2,?3)",nativeQuery = true)
    void add(String sid,String sname,String sdesc);

    @Transactional
    @Modifying
    @Query(value = "update mv_type m set m.sname=:name,m.sdesc=:desc,m.sexpired=:expired,m.slastupdate=:lastupdate,m.slastupdateby=:lastupdateby where m.sid= :sid",nativeQuery = true)
    void update(@Param("sid") String sid,@Param("name") String name,@Param("desc") String desc,@Param("expired") String expired,@Param("lastupdate") String lastupdate,@Param("lastupdateby") String lastupdateby);

   // @Modifying
    @Query(value = "SELECT * FROM mv_type where sid = ?1",nativeQuery = true)
    MvTypes queryMv(String sid);
    //@Modifying
    /*@Query("UPDATE Person p SET p.age = :age where p.name = :name")
    int updatePersonAgeByName1(@Param("age") int age, @Param("name") String name)*/

 /*   @Query(value = "SELECT * FROM hotcomment h where h.hotout = ?1",nativeQuery = true)
    List<HotComment> queryParam1(Integer id);*/
}
