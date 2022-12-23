package com.testinium.systematicTestCase.driver;

import com.testinium.systematicTestCase.helper.ElementHelper;
import com.testinium.systematicTestCase.helper.StoreHelper;
import com.testinium.systematicTestCase.methods.*;
import com.testinium.systematicTestCase.model.ElementInfo;
import com.testinium.systematicTestCase.step.StepApiImplementation;
import com.testinium.systematicTestCase.step.StepImplementation;
import com.testinium.systematicTestCase.step.StepUtilsImplementation;
import com.testinium.systematicTestCase.utils.ReadProperties;
import com.thoughtworks.gauge.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import static org.apache.logging.log4j.LogManager.*;

public class Driver {

    private static final Logger logger = LogManager.getLogger(Driver.class);
    public static String osName = FindOS.getOperationSystemName();
    public static ConcurrentHashMap<String,Object> TestMap;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String,Object>> apiMap;
    public static String slash = System.getProperty("file.separator");
    public static String TestCaseName = "";
    public static String TestClassName = "";
    public static boolean isTestinium = false;
    public static String userDir = Paths.get("").toAbsolutePath().toString();
    public static ResourceBundle ConfigurationProp = ReadProperties.readPropDir("src/test/resources/Configuration.properties");
    public static String browserName;
    public static boolean isFullScreen;
    public static WebDriver webDriver;
    public static String baseUrl;
    public static String platformName;
    public static String key;
    public static boolean chromeZoomCondition = false;
    public static boolean firefoxZoomCondition = false;
    public static boolean isSafari = false;
    public static boolean zoomCondition = false;
    public static long waitElementTimeout;
    public static long pollingEveryValue;

    @BeforeSuite
    public void beforeSuite(ExecutionContext executionContext) {

        // userDir = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        key = System.getenv("key");
        if(StringUtils.isNotEmpty(key)){
            isTestinium = true;
        }
        if (Boolean.parseBoolean(ConfigurationProp.getString("log4jColorActive")) && !isTestinium){
            LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
            File file = new File("./src/test/resources/log4j2Local.properties");
            loggerContext.setConfigLocation(file.toURI());
        }
        logger.info("*************************************************************************");
        logger.info("------------------------TEST PLAN-------------------------");
        beforePlan();
    }

    @BeforeSpec
    public void beforeSpec(ExecutionContext executionContext) {

        logger.info("=========================================================================");
        logger.info("------------------------SPEC-------------------------");
        String fileName = executionContext.getCurrentSpecification().getFileName();
        TestClassName = fileName.replace(userDir,"");
        logger.info("SPEC FILE NAME: " + TestClassName);
        logger.info("SPEC NAME: " + executionContext.getCurrentSpecification().getName());
        logger.info("SPEC TAGS: " + executionContext.getCurrentSpecification().getTags());
    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext) throws MalformedURLException, Exception {

        logger.info("_________________________________________________________________________");
        logger.info("------------------------SCENARIO-------------------------");
        TestCaseName = executionContext.getCurrentScenario().getName();
        logger.info("SCENARIO NAME: " + TestCaseName);
        logger.info("SCENARIO TAG: " + executionContext.getCurrentScenario().getTags().toString());
        String specPath = osName.equals("WINDOWS") ? TestClassName.replace("\\","/"): TestClassName;
        if (specPath.startsWith("/specs/Api")){
            if (!isTestinium){
                System.out.println(Locale.getDefault());
                Locale.setDefault(Locale.ENGLISH);
                System.out.println(Locale.getDefault());
            }
            platformName = FindOS.getOperationSystemName();
            logger.info("====================Api Test====================");
            return;
        }
        beforeTest();

    }

    @BeforeStep
    public void beforeStep(ExecutionContext executionContext) {

        logger.info("═════════  " + executionContext.getCurrentStep().getDynamicText() + "  ═════════");
    }

    @AfterStep
    public void afterStep(ExecutionContext executionContext) throws IOException {

        if (executionContext.getCurrentStep().getIsFailing()) {

            // String errorMessage = executionContext.getCurrentStep().getErrorMessage();
            // logger.error(errorMessage);
            if (Driver.TestMap.containsKey("lastElement")) {
                ElementInfo elementInfo = (ElementInfo) Driver.TestMap.get("lastElement");
                int i = elementInfo.getFileNameIndex();
                logger.warn("LastElement: " + elementInfo.getKey() + " elementi " + elementInfo.getType() + " " + elementInfo.getValue() + " Json dosya yolu: "
                        + (i == -1 ? "Element createElementInfo metoduyla oluşturulmuş" : StoreHelper.INSTANCE.getFileName(i)));
            }
            logger.error("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        }else {
            logger.info("══════════════════════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    @AfterScenario
    public void afterScenario(ExecutionContext executionContext) {

        afterTest();
        if (executionContext.getCurrentScenario().getIsFailing()) {

            logger.error("TEST BAŞARISIZ");
            logger.error("_________________________________________________________________________");
        } else {

            logger.info("TEST BAŞARILI");
            logger.info("_________________________________________________________________________");
        }

    }

    @AfterSpec
    public void afterSpec(ExecutionContext executionContext) {

        logger.info("=========================================================================");
    }

    @AfterSuite
    public void afterSuite(ExecutionContext executionContext) {

        afterPlan();
        logger.info("*************************************************************************");
    }

    public void beforePlan(){

        TestMap = new ConcurrentHashMap<String, Object>();
        apiMap = new ConcurrentHashMap<String, ConcurrentHashMap<String,Object>>();
        System.setProperty("polyglot.engine.WarnInterpreterOnly", "false");

        String waitElementTimeoutName = Driver.isTestinium ? "testiniumWaitElementTimeout": "localWaitElementTimeout";
        String pollingEveryValueName = Driver.isTestinium ? "testiniumPollingEveryMilliSecond": "localPollingEveryMilliSecond";
        waitElementTimeout = Long.parseLong(ConfigurationProp.getString(waitElementTimeoutName));
        pollingEveryValue = Long.parseLong(ConfigurationProp.getString(pollingEveryValueName));
        String rootLogLevel = ConfigurationProp.getString("logLevel").trim();
        Configurator.setRootLevel(Level.toLevel(rootLogLevel));

        String methodsClassLogLevel = ConfigurationProp.getString("methodsClassLogLevel");
        String elementHelperLogLevel = ConfigurationProp.getString("elementHelperLogLevel");
        Configurator.setLevel(getLogger(Driver.class), Level.ALL);
        Configurator.setLevel(getLogger(LocalBrowserExec.class), Level.ALL);
        Configurator.setLevel(getLogger(TestiniumBrowserExec.class), Level.ALL);
        Configurator.setLevel(getLogger(FindOS.class), Level.ALL);
        Configurator.setLevel(getLogger(StoreHelper.class), Level.toLevel(elementHelperLogLevel));
        Configurator.setLevel(getLogger(ElementHelper.class), Level.toLevel(elementHelperLogLevel));
        Configurator.setLevel(getLogger(StepImplementation.class), Level.ALL);
        Configurator.setLevel(getLogger(StepApiImplementation.class), Level.ALL);
        Configurator.setLevel(getLogger(StepUtilsImplementation.class), Level.ALL);
        Configurator.setLevel(getLogger(Methods.class), Level.toLevel(methodsClassLogLevel));
        Configurator.setLevel(getLogger(MethodsUtil.class), Level.toLevel(methodsClassLogLevel));
        Configurator.setLevel(getLogger(ApiMethods.class), Level.toLevel(methodsClassLogLevel));
        Configurator.setLevel(getLogger(JsMethods.class), Level.toLevel(methodsClassLogLevel));
        Configurator.setLevel(getLogger(ActionMethods.class), Level.toLevel(methodsClassLogLevel));
        Configurator.setLevel(getLogger(ReadJsonMethods.class), Level.toLevel(methodsClassLogLevel));
    }

    public void beforeTest(){

        try {
            createDriver();
        }catch (Throwable e) {

            StackTraceElement[] stackTraceElements = e.getStackTrace();
            String error = e.toString() + "\r\n";
            for (int i = 0; i < stackTraceElements.length; i++) {

                error = error + "\r\n" + stackTraceElements[i].toString();
            }
            throw new SessionNotCreatedException(error);
        }
    }

    public void afterTest() {

        if (isTestinium || Boolean.parseBoolean(ConfigurationProp.getString("localQuitDriverActive"))) {
            quitDriver();
        }
    }


    public void afterPlan(){

        System.out.println("");
    }

    public void createDriver() throws Exception {

        browserName = ConfigurationProp.getString("browserName");
        baseUrl = ConfigurationProp.getString("baseUrl");
        isFullScreen = Boolean.parseBoolean(ConfigurationProp.getString("isFullScreen"));
        if(!isTestinium) {
            platformName = FindOS.getOperationSystemNameExpanded();
            webDriver = LocalBrowserExec.LocalExec(browserName);
        }
        else {
            webDriver = TestiniumBrowserExec.TestiniumExec(key);
        }

        logger.info("Driver ayağa kaldırıldı.");
        isSafari = browserName.equalsIgnoreCase("safari");
        zoomCondition = (browserName.equalsIgnoreCase("chrome") && chromeZoomCondition)
                || (browserName.equalsIgnoreCase("firefox") && firefoxZoomCondition);

        //----------Base URL Kullanmak için Aşağıdaki satırı aktif hale getirin----------
        //webDriver.get(baseUrl);
    }

    public void quitDriver() {

        if(webDriver != null){
            webDriver.quit();
            logger.info("Driver kapatıldı.");
        }
    }

    /**
     System.out.println(System.getProperty("user.dir"));
     System.out.println(System.getProperty("user.home"));
     System.out.println(System.getProperty("user.name"));
     System.out.println(System.getProperty("file.separator"));
     System.out.println(System.getProperty("file.encoding"));
     */

}
