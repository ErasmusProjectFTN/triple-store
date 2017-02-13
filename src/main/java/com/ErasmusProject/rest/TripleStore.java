package com.ErasmusProject.rest;
import com.ErasmusProject.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Komp on 13.2.2017.
 */

@RestController
public class TripleStore {
    @RequestMapping("/greeting")
    public Response greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Response("Hello", name);
    }

}
