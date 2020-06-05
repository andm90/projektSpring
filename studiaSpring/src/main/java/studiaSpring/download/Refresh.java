package studiaSpring.download;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.Scanner;

import studiaSpring.entity.Wig20;
import studiaSpring.service.Wig20Service;

public class Refresh {
	
	private String link;
	Wig20Service wig20Service;
	
	public Refresh(Wig20Service wig20Service, String link) {
		
		this.wig20Service = wig20Service;
		this.link = link;
	}
	
	public void update() throws IOException{
		
		try {
			
				URL url = new URL(link);
				URLConnection connection = url.openConnection();
				connection.connect();
			
				String encoding = connection.getContentEncoding();
				if(encoding == null) {
					encoding = "UTF-8";
				}
			
				wig20Service.deleteAll();
				
				Scanner in = new Scanner(connection.getInputStream(), encoding);

				in.nextLine();
				for(int n=1; in.hasNextLine(); n++) {
				
					String[] line = in.nextLine().split(",");
				
					LocalDate theDate = createDateOfTheDay(line);

					wig20Service.save(new Wig20(
						theDate,
						Double.parseDouble(line[1]),
						Double.parseDouble(line[2]),
						Double.parseDouble(line[3]),
						Double.parseDouble(line[4]),
						Integer.parseInt(line[5])));
						
				}
			
		}catch(IOException e) {
			e.printStackTrace();
			throw new IOException("problem with connect with external web");
		}
	}

	LocalDate createDateOfTheDay(String[] line) {
		
		String[] theDay = line[0].split("-");
		
		int year = Integer.parseInt(theDay[0]);
		int month = Integer.parseInt(theDay[1]);
		int day = Integer.parseInt(theDay[2]);
		
		return LocalDate.of(year,month,day);
	}
	
	

}
