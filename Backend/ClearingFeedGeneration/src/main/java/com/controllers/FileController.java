package com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.FeedFile;
import com.dao.FeedFileImpl;
import com.pojo.Archive;
import com.pojo.CurrentInvalid;
import com.pojo.CurrentValid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FileController {
	
	@Autowired
	FeedFile feedfile;
	
	@Autowired
	FeedFileImpl feedfileimpl;

	@RequestMapping(value = "/current_valid", method = RequestMethod.GET)
	public List<CurrentValid> get_valid() {
		List<CurrentValid> valid = feedfile.show_valid();
		return valid;
	}
	
	@RequestMapping(value = "/current_invalid", method = RequestMethod.GET)
	public List<CurrentInvalid> get_invalid() {
		List<CurrentInvalid> invalid = feedfile.show_invalid();
		return invalid;
	}
	
	@RequestMapping(value = "/archive", method = RequestMethod.GET)
	public List<Archive> get_archive() {
		List<Archive> archive = feedfile.show_archive();
		return archive;
	}
	
}
