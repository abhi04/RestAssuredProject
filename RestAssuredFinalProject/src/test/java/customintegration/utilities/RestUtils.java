package customintegration.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
/*
 * Creating a Static Method for generating Different Channel Names
 * 
 * 
 */
	public static String ChannelGenerator() {
		String empname = RandomStringUtils.randomAlphabetic(1);
		String name = "Channel"+empname;
		return name;
	}
	


}

