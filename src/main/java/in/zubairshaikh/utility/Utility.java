package in.zubairshaikh.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class Utility {

	private static Logger logger = LoggerFactory.getLogger(Utility.class);

	public static int getMonthNumber(String expiryDate) {

		String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
				"OCTOBER", "NOVEMBER", "DECEMBER" };

		String month = expiryDate.split("-")[0];

		logger.info("Month {}", month);

		return getIndexOf(months, month) + 1;

	}

	public static Date getDate(String expiryDate) throws ParseException {

		Date date = new SimpleDateFormat("MMM-yyyy").parse(expiryDate);
		return date;
	}

	public static int getIndexOf(String[] arr, String month) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].startsWith(month.toUpperCase())) {

				return i;
			}

		}

		return -1;
	}
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(getDate("Nov-2017"));
		
	}
	
	 public static File convertMultiPartToFile(MultipartFile file ) throws IOException
	    {
		 
	        File convFile = new File( "/opt/tomcat/"+file.getOriginalFilename() );
	        convFile.getParentFile().mkdirs(); // correct!
			if (!convFile.exists()) {
				convFile.createNewFile();
			}
	        FileOutputStream fos = new FileOutputStream( convFile );
	        fos.write( file.getBytes() );
	        fos.close();
	        return convFile;
	    }

}
