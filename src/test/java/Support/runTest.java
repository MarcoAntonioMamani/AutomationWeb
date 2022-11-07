package Support;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import java.io.IOException;


@Test
@CucumberOptions(plugin = { "pretty"},
        tags = "",
        features = "src/test/resources/features",
        glue = "Definitions")

public class runTest extends AbstractTestNGCucumberTests {


    @Parameters({ "BrowserType" })
   // @DataProvider(parallel = true)
    @BeforeMethod(alwaysRun = true)
    public static void setUpScenario(String browser) {
        UtilsBrowser.Browser=browser;
       // return new Object[0];
    }

    @Parameters({ "BrowserType" })
    // @DataProvider(parallel = true)
    @BeforeClass(alwaysRun = true)
    public static void setUpScenario02(String browser) {
        UtilsBrowser.Browser=browser;
        // return new Object[0];
    }

    @Parameters({ "BrowserType" })
    // @DataProvider(parallel = true)
    @BeforeTest(alwaysRun = true)
    public static void setUpScenario03(String browser) {
        UtilsBrowser.Browser=browser;
        // return new Object[0];
    }

    @AfterSuite
    public static void finish() throws IOException {
        /*try{
            System.out.println("Generando el Reporte");
            String [] cmd={"cmd.exe","/c","npm run report"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte Generado Correctamente");

        }catch (Exception ex){
            ex.printStackTrace();
        }*/

        try{
            System.out.println("Generando el Reporte");
            String [] cmd={"powershell.exe","/","allure serve"};
            Runtime.getRuntime().exec(cmd);
            System.out.println("Reporte Generado Correctamente");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}

