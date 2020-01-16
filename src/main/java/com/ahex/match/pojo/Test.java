package com.ahex.match.pojo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ahex.match.dao.MatchInfoDAO;
import com.ahex.match.service.MatchService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Test {
	public static void main(String[] args) throws IOException, NullPointerException {
    	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		
		MatchService matchService=context.getBean(MatchService.class);
		
		//System.out.println("========================"+matchInfoDAO.toString());
    	ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    	
    	File file = new File("/home/user/Documents/Sushma/ipl");
	        
	        File[] files = file.listFiles(new FilenameFilter() {
	             
	            public boolean accept(File dir, String name) {
	                if(name.toLowerCase().endsWith(".yaml")){
	                    return true;
	                } else {
	                    return false;
	                }
	            }
	        });
	        for(File f:files){
	            //System.out.println(f.getName());
	            mapper.findAndRegisterModules();
	        	//Meta met = mapper.readValue(new File("/home/user/ElementProject/Match_Data/src/main/resources/211028.yaml"), Meta.class);
	            Meta met = mapper.readValue(f, Meta.class);
	            //Object met = mapper.readValue(new File("C://Users/LENOVO/Eclipse_neon_workspace/SpringHibernateExample/src/main/java/335982.yml"), Object.class);
	        	
	        	//System.out.println("met : " + met.toString());
	        	/*System.out.println("Info : "+met.getInfo());
	        	System.out.println("Innings : "+met.getInnings());
	        	System.out.println("Meta : "+met.getMeta());*/
	        	
	        	if (met!=null){
	        	try{
	        	//matchService.transferdataToEntity(met,context);
	       
	        		//matchService.printHello();
	        		//matchInfoDAO.saveMatchInfo(met);
	        	}catch (Exception e) {
	    			System.out.println(e);
	    		}
	    }
  	
    }
	       /* Object object = matchService.getInningDataByDeliveryBall( null ,   null,   null, context);
	        System.out.println("#################################### :::::::::" + object);
	        System.out.println(object);
	        context.close();*/
    	
    	
    }
}
