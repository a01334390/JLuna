/*
 * Built in 2017© By Worker's in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package luna;



/**
 *
 * @author a01334390
 */
public class Luna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            LoginFormShow();
        }catch(Exception e){
            System.out.println("Errors back in main");
        }
    }

    private static void LoginFormShow() {
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
    }

}