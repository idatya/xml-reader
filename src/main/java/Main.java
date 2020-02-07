

import com.sh.xml.lookup.service.LookupService;
import com.sh.xml.lookup.service.LookupServiceImpl;
import com.sh.xml.udf.UDFMapping;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Start...");
		LookupService lookupService = new LookupServiceImpl();
		UDFMapping allEDWUDFMappedToHive = lookupService.getAllEDWUDFMappedToHive("teradata");
		System.out.println(allEDWUDFMappedToHive.getUdfsList().size());
	}
}
