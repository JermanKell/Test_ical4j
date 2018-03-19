package iCal4j_Program;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


import ical4j_class.ADECalendar;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Permet de dl le fichier à partir d'un url en fixant le nom du fichier en sortie
		URL website;
		try {
			website = new URL("http://ade.univ-tours.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?data=8241fc3873200214fbe431e1562e1bad59d1daffdd8cdb51acb19d107238579addf1722e1ca669d8488e92e238df15c87696c28fd5c98554a5292037fd4acdc75c11487b535f9bdeedaaab31c0c950dc4289af46a8c45abf3a2bd049346b92fe022fde6c763cc5eb3bfbf2b3336faa6c215a92cce875c3f2a99beb675b17d343c60abe297e43c3fe96ae7ffcca1943aa152809f58cc75d058bde1f5818f87bee2b1c145d1041ab1ebc3cfa6188fe6b43903ccb7a5b493403c11bec1a7c8d3c476269ce0a9f6d68abf9c4bc151f5a340044bd181a07fbfb7b50b37189fa0b8d2bddf02cf567b72596f0d37a65452ac93c");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream("ADECal.ics");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ADECalendar ade = new ADECalendar();
		//ade.loadCalendarFromURL();
	}

}
