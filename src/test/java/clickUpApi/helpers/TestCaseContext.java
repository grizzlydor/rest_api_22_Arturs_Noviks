package clickUpApi.helpers;

import clickUpApi.domain.Folder;
import clickUpApi.domain.List;
import clickUpApi.domain.Task;
import io.cucumber.java.Scenario;

public class TestCaseContext {
    private static Scenario scenario;
    private static Folder testFolder;
    private static List testList;
    private static Task testTask;

    public static void initialize(){
        testFolder = null;
        testList = null;
        testTask = null;
    }


    public static void setTestFolder(Folder testFolder){
        TestCaseContext.testFolder = testFolder;
    }
    public static Folder getTestFolder(){
        return testFolder;
    }


    public static void setList(List testList){
        TestCaseContext.testList = testList;
    }
    public static List getList(){
        return testList;
    }


    public static void setTestTask(Task testTask){
        TestCaseContext.testTask = testTask;
    }
    public static Task getTestTask(){
        return testTask;
    }


    public static void setScenario(Scenario scenario){
        TestCaseContext.scenario = scenario;
    }
    public static Scenario getScenario(){
        return scenario;
    }




}
