package iCal4j_Program;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import ical4j_class.ADECalendar;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Permet de dl le fichier à partir d'un url en fixant le nom du fichier en sortie
		
		/*Scanner sc = new Scanner(System.in);
				
		URL website;
		String siteURL;
		
		System.out.println("Veuillez rentrer l'URL du site: \n");
		siteURL = sc.nextLine();
		
		try {
			website = new URL(siteURL);
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ADECal.ics");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		ADECalendar ade = new ADECalendar();
		ade.loadCalendarFromURL();
		ade.ReadCalEvents();
	}

}
