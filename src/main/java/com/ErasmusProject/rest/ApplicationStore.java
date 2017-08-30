package com.ErasmusProject.rest;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ErasmusProject.util.OntologyUtils;
import com.ErasmusProject.util.StringUtils;


@RestController
@RequestMapping("/application")
public class ApplicationStore {

	@RequestMapping(method = RequestMethod.GET, value="/test")
	public String test(){
		return "OK test";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addApplication")
	public String addApplication(@RequestParam(value="studentId", required=true) String studentId,
								 @RequestParam(value="programmeId", required=true) String programmeId,
								 @RequestParam(value="passport", required=true) String passport,
								 @RequestParam(value="idCard", required=true) String idCard){
		
		String identifier = UUID.randomUUID().toString();
		String query = "PREFIX application: <" + StringUtils.namespaceApplication + "> "
				+"INSERT DATA"
				+"{"
				+" application:" + identifier + " application:applicationId \"" + identifier.replaceAll("[\\t\\n\\r]","") + "\" ;"
				+"								  application:studentId \""	 + studentId.replaceAll("[\\t\\n\\r]"," ") + "\" ;"
				+"								  application:degreeProgrammeId \"" + programmeId.replaceAll("[\\t\\n\\r]"," ") + "\" ;"
				+"								  application:passport \"" + passport.replaceAll("[\\t\\n\\r]"," ") + "\" ;"
				+"								  application:idCard \"" + idCard.replaceAll("[\\t\\n\\r]"," ") + "\" ;"
				+"								  application:status \"" + "Processing\"."	
				+"}";
		
		System.out.println(query);
		try{
			OntologyUtils.execUpdate(StringUtils.URLupdate, query);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return "Successfully created application";
	}
}
