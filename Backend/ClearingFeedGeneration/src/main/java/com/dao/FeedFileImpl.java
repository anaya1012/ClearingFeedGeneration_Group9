package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pojo.Archive;
import com.pojo.CurrentInvalid;
import com.pojo.CurrentValid;

@Repository
public class FeedFileImpl implements FeedFile {
	
	@Autowired
	CurrentValid c;
	@Autowired
	CurrentInvalid ci;
	@Autowired
	Archive a;
	@Autowired
	FeedFileJdbcTemplate t;
	@Autowired
	Validation v;
	@Autowired 
	JdbcTemplate template;
	
	static int file_no=1;
	
	private final Path root = Paths.get("downloads");
	
	@PostConstruct
	public void init() {
		try {
			if(!Files.exists(root))
			{
				Files.createDirectory(root);
			}
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for download!");
		}
	}

	@Override
	public void readfile(String filename) {
		// TODO Auto-generated method stub
		
		
		File file=new File("uploads/"+filename);    //creates a new file instance  
		FileReader fr;
		
		
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("downloads/validfile.txt"));
			
			fr = new FileReader(file);
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			String line; 
			String obj[];

			while((line=br.readLine())!=null)  
			{  
				obj=line.split(" ");
				//Date date = new SimpleDateFormat("ddMMyyyy").parse(obj[1]);
				//String formatdate = new SimpleDateFormat("dd/MM/yyyy").format(date);
				//Date d=new SimpleDateFormat("dd/MM/yyyy").parse(formatdate);
				Date d=new SimpleDateFormat("dd/MM/yyyy").parse(obj[1]);
				String formatdate = new SimpleDateFormat("dd/MM/yyyy").format(d);
				System.out.println(formatdate);
				
				if(v.validate(obj)==1) {
					c.setTrans_ref(Long.parseLong(obj[0]));
					c.setDate(d);
					c.setPayerName(obj[2]);
					c.setPayerAccount(obj[3]);
					c.setPayeeName(obj[4]);
					c.setPayeeAccount(obj[5]);
					c.setAmount(Double.parseDouble(obj[6]));
					System.out.println(c.getDate());
					
				    writer.write(c.getTrans_ref()+" "+c.getDate()+" "+c.getPayerName()+" "+c.getPayerAccount()+" "+c.getPayeeName()+" "+c.getPayeeAccount()+" "+c.getAmount()+"\n");
					
					t.addcurrent_valid(c);  //function call
				}
				else {
					ci.setIdate(formatdate);
					ci.setItrans_ref(obj[0]);
					ci.setIpayerName(obj[2]);
					ci.setIpayerAccount(obj[3]);
					ci.setIpayeeName(obj[4]);
					ci.setIpayeeAccount(obj[5]);
					ci.setIamount(obj[6]);
					t.addcurrent_invalid(ci); //function call
				}
					
				a.setAdate(formatdate);
				a.setAtrans_ref(obj[0]);
				a.setApayerName(obj[2]);
				a.setApayerAccount(obj[3]);
				a.setApayeeName(obj[4]);
				a.setApayeeAccount(obj[5]);
				a.setAamount(obj[6]);
				if(v.validate(obj)==1)
					a.setValid(1);
				else
					a.setValid(0);
				a.setFileNo(file_no);
				t.addarchive(a);  //function call
			}
			fr.close();
			writer.close();
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		file_no++;
		
	}

	@Override
	public List<CurrentValid> show_valid() {
		// TODO Auto-generated method stub
		
		String curr="Select * from current_valid";
		List<CurrentValid> valid = template.query(curr, new RowMapper<CurrentValid>() {

			@Override
			public CurrentValid mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new CurrentValid(set.getLong(1),set.getDate(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getDouble(7));
			}

		});

		return valid;
		
	}

	@Override
	public List<CurrentInvalid> show_invalid() {
		// TODO Auto-generated method stub
		String curr="Select * from current_invalid";
		List<CurrentInvalid> invalid = template.query(curr, new RowMapper<CurrentInvalid>() {

			@Override
			public CurrentInvalid mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new CurrentInvalid(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(6),set.getString(8));
			}

		});

		return invalid;
		
	}

	@Override
	public List<Archive> show_archive() {
		// TODO Auto-generated method stub
		String curr="Select * from archive";
		List<Archive> archive = template.query(curr, new RowMapper<Archive>() {

			@Override
			public Archive mapRow(ResultSet set, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				return new Archive(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getInt(9),set.getInt(10));
			}

		});

		return archive;
		
		
	}

}
