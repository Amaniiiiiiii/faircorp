package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoomDaoTest {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private WindowDao windowDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
    }

    @Test
    public void shouldFindRoosByName(){
        Room room = roomDao.findRoomByName("Room1");
        Assertions.assertThat(room.getId()).isEqualTo(-10L);
    }

    @Test
    public void shouldDeleteWindowsRoom() {
        Room room = roomDao.getById(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        System.out.println("影响的元素数量是 : "+windowDao.deleteAllWindowsInARoom(-10L));
        List<Window> result = windowDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }

}