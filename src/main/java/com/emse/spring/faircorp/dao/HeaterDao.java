package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface HeaterDao extends JpaRepository<Heater,Long>,HeaterDaoCustom {

    //这样的写法不需要再写一个custom实现类，对于比较简单的sql可以直接注释解决。
    @Modifying
    @Query("delete from Heater h where h.room.id = :id")
    int deleteAllHeatersInARoom(Long id);
}
