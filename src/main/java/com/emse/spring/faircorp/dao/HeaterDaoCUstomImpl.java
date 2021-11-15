package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCUstomImpl implements HeaterDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findByRoomId(Long id) {
        String jpql = "select h from Heater h where h.room.id = :id";
        return em.createQuery(jpql, Heater.class).setParameter("id",id).getResultList();

    }

}
