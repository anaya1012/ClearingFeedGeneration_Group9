package com.dao;

import java.util.List;

import com.pojo.Archive;
import com.pojo.CurrentInvalid;
import com.pojo.CurrentValid;

public interface FeedFile {
	public void readfile(String filename);
	public List<CurrentValid> show_valid();
	public List<CurrentInvalid> show_invalid();
	public List<Archive> show_archive();
}
