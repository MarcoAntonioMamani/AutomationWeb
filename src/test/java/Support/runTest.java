package Support;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
/*
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Definitions",  //el nombre de las clases implementadas de los features
        // plugin = {"json:target/cucumber-reporte/cucumber.json","html:target/cucumber-report/cucumber-report.html"},
        plugin = {"json:src/test/resource/report/cucumber_report.json"},
        tags = "not @Pruebita"
)*/


@Test
@CucumberOptions(plugin = { "pretty"},
        tags = "",
        features = "src/test/resources/features",
        glue = "Definitions")

public class runTest extends AbstractTestNGCucumberTests {


    @Parameters({ "BrowserType" })
    @BeforeTest
    public static void setUpScenario(String browser) {
        UtilsBrowser.Browser=browser;
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

