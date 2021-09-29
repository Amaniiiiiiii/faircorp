package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.data.JDBCconfiguration;
import com.emse.spring.faircorp.data.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//CREATE TABLE SITE(ID VARCHAR(255) NOT NULL PRIMARY KEY, NAME VARCHAR(255) NOT NULL);
@RestController
public class DataController {

    @Autowired
    JDBCconfiguration jdbCconfiguration;


    @PostMapping(value = "/user")
    public void addUser(@RequestParam("ID") String ID, @RequestParam("name") String name) {
        Site site = new Site(ID,name);
        jdbCconfiguration.insertSite(site);
    }
}


