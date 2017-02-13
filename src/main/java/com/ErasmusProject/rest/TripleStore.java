package com.ErasmusProject.rest;
import com.ErasmusProject.util.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Komp on 13.2.2017.
 */

@RestController
@RequestMapping("/add")
public class TripleStore {

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public Response addStudent(@RequestParam("surname") String surname,
                               @RequestParam("name") String name,
                               @RequestParam("dateOfBirth") String dob,
                               @RequestParam("countryofBirth") String cob,
                               @RequestParam("placeOfBirth") String pob,
                               @RequestParam("gender") String gender,
                               @RequestParam("nationality") String nat,
                               @RequestParam("streetAndNumber") String san,
                               @RequestParam("postalCode") String pcode,
                               @RequestParam("city") String city,
                               @RequestParam("country") String cor,
                               @RequestParam("telephone") String tel,
                               @RequestParam("email") String email)
    {
        return new Response("Hello", "World");
    }

}
