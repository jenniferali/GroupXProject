package utils;

public class Constants {
    // THIS IS WHERE WE PROVIDE THE ACTUAL FILEPATH of our config.properties file which includes
    // browser, url, username & password
    // USER.DIR is the project file path
    // must concatenate with config.properties to get a filepath that any user can access!
    public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;
    public static final String TEST_DATA_FILEPATH = System.getProperty("user.dir")+"/src/test/resources/testData/Batch13ExcelFile.xlsx";
    public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir")+"/screenshots/";

}

