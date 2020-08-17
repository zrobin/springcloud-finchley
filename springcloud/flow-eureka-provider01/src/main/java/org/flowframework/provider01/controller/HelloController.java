package org.flowframework.provider01.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : robin
 * @Date   : 2020-08-01
 */

@RestController
@RequestMapping(value="/hello", produces="application/json")
public class HelloController {

    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    public String hello(@PathVariable("name") String name) {
        return "Hello " + name + ", service: provider01";
    }
}
