package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    public RoomController(RoomDao roomDao,WindowDao windowDao,HeaterDao heaterDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping
    public List<RoomDto> findAll(){
        //http://localhost:8080/api/rooms
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id){
        //http://localhost:8080/api/rooms/-10
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto){
        /**
         * {
         *     "floor": 2,
         *     "name": "wenxu room",
         *     "currentTemperature": 19.2,
         *     "targetTemperature": 29.1
         * }
         * 加上id就会返回已有的
         */
        Room room = null;
        if(dto.getId() == null){
            room = roomDao.save(new Room(dto.getFloor(),dto.getName(),dto.getCurrentTemperature(),dto.getCurrentTemperature()));
        }else{
            room = roomDao.getById(dto.getId());
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        List<Window> windows = windowDao.findByRoomId(id);
        List<Heater> heaters = heaterDao.findByRoomId(id);
        windowDao.deleteAll(windows);
        heaterDao.deleteAll(heaters);
        //need to delete all the heater and windows first
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switchWindow")
    public void switchWindowStatus(@PathVariable Long id){
        List<Window> windows = windowDao.findByRoomId(id);
        for(Window each: windows){
            each.setWindowStatus(each.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        }
    }

    @PutMapping(path = "/{id}/switchHeater")
    public void switchHeaterStatus(@PathVariable Long id){
        List<Heater> heaters = heaterDao.findByRoomId(id);
        for(Heater each: heaters){
            each.setHeaterStatus(each.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        }
    }

}
