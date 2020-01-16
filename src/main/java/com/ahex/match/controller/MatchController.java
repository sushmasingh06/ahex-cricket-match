package com.ahex.match.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.FinalDto;
import com.ahex.match.pojo.Meta;
import com.ahex.match.service.MatchService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


@RestController
@RequestMapping("/matchdata")
public class MatchController {

	@Autowired
	private MatchService matchService;
	
	 @PutMapping("/savematchinfo")
	   public ResponseEntity<?> save(@RequestParam(required=true) String path) {
	    	ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
	    	
	    	/*File file = new File("/home/user/Documents/Sushma/ipl");*/
	    	File file = new File(path);    
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
		            mapper.findAndRegisterModules();
		            Meta met=null;
		            System.out.println(f.getName());
					try {
						met = mapper.readValue(f, Meta.class);
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  	
		            matchService.transferdataToEntity(met);
	    }
	      return ResponseEntity.ok().body("Save Successful");
	 }

	@GetMapping("/match")
	   public ResponseEntity<List<String>> getTeamName( String team) {
		List<String> inningEntity = matchService.getTeamName(team);
	      return ResponseEntity.ok().body(inningEntity);
	   }
	
	
/*	@RequestMapping(value="postTeamInfo", method = RequestMethod.POST , produces = { "application/json; charset=UTF-8" }, consumes = {"application/json; charset=UTF-8" }  )
*/
	@PostMapping(value="teamInfo" , produces = { "application/json; charset=UTF-8" }, 
			consumes = {"application/json; charset=UTF-8" } )
	public ResponseEntity<FinalDto> getTeamInfo(@RequestBody FilterDto filterDto ,  @RequestParam (required=false) String year, @RequestParam(required=false) String teamName){
		FinalDto result = matchService.getTeamInfo(filterDto, year,teamName);
		return ResponseEntity.ok().body(result);
		 
	}
	
	//@PostMapping("/getMatchInfo")
		@PostMapping(value="matchInfo" , produces = { "application/json; charset=UTF-8" }, 
				consumes = {"application/json; charset=UTF-8" } )
		//public ResponseEntity<FinalDto> getMatchInfo(@RequestParam(required= true) String filterType, @RequestParam(required = true) String filterValue){
		public ResponseEntity<FinalDto> getMatchInfo(@RequestBody FilterDto filterDto, @RequestParam(required = false) String filterType, @RequestParam(required = false) String filterValue){	
			FinalDto result = matchService.getMatchInfo(filterType, filterValue,filterDto);
			
			return ResponseEntity.ok().body(result);
			
		}
	
	
	
   
}
