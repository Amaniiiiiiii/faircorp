package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.data.JDBCconfiguration;
import com.emse.spring.faircorp.data.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//CREATE TABLE SITE(ID VARCHAR(255) NOT NULL PRIMARY KEY, NAME VARCHAR(255) NOT NULL);
@Controller
public class DataController {

    @Autowired
    JDBCconfiguration jdbCconfiguration;


    @GetMapping(value = "/user")
    public void addUser(@RequestParam("ID") String ID, @RequestParam("name") String name) {
        Site site = new Site("123","wenxu");
        jdbCconfiguration.insertSite(site);
    }
}


