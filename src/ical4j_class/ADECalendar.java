package ical4j_class;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.*;

public class ADECalendar {
	private URL url;
	private CalendarBuilder Calbuilder;
	private URLConnection conn;
	private Calendar ADEcal;
	
	/**
	 * @author Xavier Bouchenard
	 * @exception MalformedException e		An exception of this type will be throwed if the new URL is malformed
	 * Builds an object of the ADECalendar class
	 */
	public ADECalendar() {
		System.out.println("Please enter the url of the calendar to load\n");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str);
		try {
			this.url = new URL(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calbuilder = new CalendarBuilder();
	}
	
	
	/**
	 * @author Xavier Bouchenard
	 * @exception IOException e		An exception of this type will be throwed if a connection's attempt failed
	 * @exception ParserException e		An exception of this type will be throwed if a building's attempt failed
	 * Enables the loading of a calendar from an URL
	 */
	public void loadCalendarFromURL() {
		try {
			conn = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection failed from this url: " + url.toString());
		}
		
		try {
			InputStream in = conn.getInputStream();
			try {
				ADEcal = Calbuilder.build(in);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error occured while building a new calendar from this url: " 
				+ url.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("The system failed to open a connection from this url " 
			+ url.toString());
		}
		
		System.out.println("The loading of the calendar succeed\n");
	}
	
	
	
	
}
