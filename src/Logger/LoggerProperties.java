package Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerProperties {
	public static Logger logger = Logger.getLogger(Class.class.getName());
	public static FileHandler fh;	
	public static void logProperties() throws SecurityException, IOException
	{
		try
		{
		fh=new FileHandler("D:\\Logger.txt");
	    logger.addHandler(fh);
	    SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
		}catch(Exception e)
		{
			logger.info(e.getMessage());
		}
	}
	static {
		try {
			logProperties();
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
