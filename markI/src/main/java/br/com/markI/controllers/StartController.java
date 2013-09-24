package br.com.markI.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/start/")
public class StartController  extends BaseController{

	
	public static void main(String[] args) {
		String rootPath = "c:/estados/";
		
		File rootPathFile = new File(rootPath);
		File[] listFiles = rootPathFile.listFiles(new FileFilter(){

			public boolean accept(File pathname) {
				
				return pathname.getName().endsWith(".sql");
			}
			
			
		});
		
		int count = 0;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
	      // Setup the connection with the DB
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/marki?user=root&password=root");
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		 
	      
		for (File file : listFiles) {
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				while(br.ready()){
					String readLine = br.readLine().trim();
					if(readLine.startsWith("id=")){
						
						String[] split = readLine.split(",");
						String id = split[0].replaceAll("id=", "");
						String longitude = split[1].replaceAll("longitude=", "");
						String latitude = split[2].replaceAll("latitude=", "");
						
						//System.out.println(id+"::"+longitude+"::"+latitude);
						
						preparedStatement = connect
						          .prepareStatement("UPDATE municipio "+ 
						       "set longitude = ? , latitude = ?  WHERE id = ?");
						preparedStatement.setString(1, longitude);
						preparedStatement.setString(2, latitude);
						preparedStatement.setLong(3, Long.valueOf(id));
						preparedStatement.executeUpdate();
						
						count++;
					}
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(count);
		
		
	}
}

