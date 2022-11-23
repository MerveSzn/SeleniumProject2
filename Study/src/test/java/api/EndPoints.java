package api;

/**
 * @author merve.sozen
 */
public class EndPoints {

    /*COMMON ENDPOINTS*/
    public static String base_url = "http://127.0.0.1:8081/";
    public static String login_url = "user/login?username=merve";

    /*CALCULATOR ENDPOINTS*/
    public static final String sumExample1="add?params=1,2";
    public static final int sumExampleResult1=3;
    public static final String multiExample2="multiplication?params=3,2,3";
    public static final int multiExampleResult2=18;
    public static final String divisionExample3="division?params=55,11";
    public static final int divisionExampleResult3=5;

    /*SUM ENDPOINTS*/
    public static final String getSumExample1 ="sum?params=5";
    public static final int getSumExampleResult1 =15;
    public static final String getSumExample2="sum?params=4";
    public static final int getSumExampleResult2=10;
}
