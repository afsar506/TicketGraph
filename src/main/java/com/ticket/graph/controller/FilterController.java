package com.ticket.graph.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.graph.entity.Filter;
import com.ticket.graph.entity.dto.ConfigItemAndTaskTypeRequestDto;
import com.ticket.graph.entity.dto.FIlterDataResponse;
import com.ticket.graph.entity.dto.FilterDataSaveDto;
import com.ticket.graph.entity.dto.PriorityConfigurationRequestDto;
import com.ticket.graph.entity.dto.SearchByNumberDto;
import com.ticket.graph.service.FilterService;

@RestController
@CrossOrigin
public class FilterController {
	@Autowired
	public FilterService filterService;

	@GetMapping("/")
	public String home() {
		return "welcome to my home ";
	}

	@PostMapping("/data")
	public String save(@RequestBody FilterDataSaveDto data) {
		String res = filterService.save(data);
		return res;
	}

	@GetMapping("/tasktype")
	public Map<String, Long> tasktype() {
		return filterService.tasktype();
	}
	@GetMapping("/state")
	public Map<String, Long> state() {
		return filterService.state();
	}
	@GetMapping("/priority")
	public Map<String, Long> priority() {
		return filterService.priority();
	}
	@GetMapping("/assignment-group")
	public Map<String, Long> assignmentGroup() {
		return filterService.assignmentGroup();
	}
	@GetMapping("/configuration-item")
	public Map<String, Long> configurationItem() {
		return filterService.configurationItem();
	}
	@GetMapping("/opened")
	public Map<String, Long> opened() {
		return filterService.opened();
	}
	@PostMapping("/search-by-number")
	public FIlterDataResponse searchByNumber(@RequestBody SearchByNumberDto search) {
		 FIlterDataResponse res= filterService.searchByNumber(search.getNumber());
		 return res;
	}
	
	@PostMapping("priority-configuration")
	public int priorityConfiguration(@RequestBody PriorityConfigurationRequestDto configurationRequestDto){
		return filterService.priorityConfiguration(configurationRequestDto);
	}
	
	@PostMapping("configuration-tasktype")
	public int configurationTasktype(@RequestBody ConfigItemAndTaskTypeRequestDto taskTypeRequestDto){
		return filterService.taskTypeConfiguration(taskTypeRequestDto);
	}
	
	
	@GetMapping("/ticket-details")
	public List<Filter> getfilters() {
		return this.filterService.getFilterData();
	}

	
	
	
	
}
