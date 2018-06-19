package helpers;
//import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	 
	
	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(org.apache.log4j.Logger.class.getName());
	
//	public static Logger log=Logger.getLogger(Logger.class.getName());
	public Log(){	
		
//		 DOMConfigurator.configure("log4j.xml");
//		 DOMConfigurator.configure("Log4j.properties");
			PropertyConfigurator.configure("Log4j.properties");
	}
	
	
	
	
	
//	private static Logger Log = Logger.getLogger(Log.class.getName()); 
//	
//	 
//	
//	public static void startTestCase(String sTestCaseName){
//		Log.info("Started Test case");
//	}
//
//
//	public static void endTestCase(String sTestCaseName){
//		Log.info("Ended Test Case");
//	}
//
//	public static void info(String message)
//	{
//		Log.info(message);
//	}
}