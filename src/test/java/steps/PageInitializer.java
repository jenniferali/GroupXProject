package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeInformationPage;
import pages.LoginPage;

// This class creates a function that will initialize all the page objects
public class PageInitializer {

    //define objects
    public static LoginPage login;
    public static DashboardPage dash;
    public static EmployeeInformationPage emp;
    public static AddEmployeePage addEmployeePage;

    //write function-- will initialize all page objects
    public static void initializePageObjects(){
        login = new LoginPage();
        dash = new DashboardPage();
        emp = new EmployeeInformationPage();
        addEmployeePage = new AddEmployeePage();
    }


}