import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Tariq Shaath
 *
 */
public class PasswordCheckerUtility {
    /**
     * @param password
     * @param passwordConfirm
     * @return void
     */

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {


        if (!password.equals(passwordConfirm))
            throw new UnmatchedException();
    }


    /**
     * @param password
     * @param passwordConfirm
     * @return boolean
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if (password.equals(passwordConfirm))
            return true;
        else
            return false;
    }

    /**
     * @param password
     * @return boolean
     * @throws LengthException
     */
    public static boolean isValidLength(String password) throws LengthException {
        if (!(password.length() >= 6)) {
            throw new LengthException();

        }
        return true;


    }


    /**
     * @param password
     * @return boolean
     */

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        for (int i=0; i<password.length(); i++)
        {

            char n=password.charAt(i);
            String str=String.valueOf(n);
            Pattern pattern = Pattern.compile("[A-Z]*");
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches())
                return true;

        }
        throw new NoUpperAlphaException();

    }

    /**
     * @param password
     * @return boolean
     * @throws NoLowerAlphaException
     */

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
    {
        for (int i=0; i<password.length(); i++)
        {

            char n=password.charAt(i);
            String str=String.valueOf(n);
            Pattern pattern = Pattern.compile("[a-z]*");
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches())
                return true;

        }
        throw new NoLowerAlphaException();
    }

    /**
     * @param password
     * @return boolean
     * @throws NoDigitException
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        for (int i=0; i<password.length(); i++)
        {

            char n=password.charAt(i);
            String str=String.valueOf(n);
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches())
                return true;

        }
        throw new NoDigitException();
    }

    /**
     * @param password
     * @return boolean
     * @throws NoSpecialCharacterException
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches())
            return true;
        else {


            throw new NoSpecialCharacterException();
        }
    }


    /**
     * @param password
     * @return boolean
     * @throws InvalidSequenceException
     */
    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                throw new InvalidSequenceException();
            }


        }
        return true;
    }

    /**
     * @param password
     * @return boolean
     * @throws LengthException
     * @throws NoUpperAlphaException
     * @throws NoLowerAlphaException
     * @throws NoDigitException
     * @throws NoSpecialCharacterException
     * @throws InvalidSequenceException
     */
    public static boolean isValidPassword(String password) throws LengthException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoDigitException,
            NoSpecialCharacterException,
            InvalidSequenceException
    {
        PasswordCheckerUtility.isValidLength(password);
        PasswordCheckerUtility.hasUpperAlpha(password);
        PasswordCheckerUtility.hasLowerAlpha(password);
        PasswordCheckerUtility.hasDigit(password);
        PasswordCheckerUtility.hasSpecialChar(password);
        PasswordCheckerUtility.NoSameCharInSequence(password);
        return true;
    }


    /**
     * @param password
     * @return boolean
     */
    public static boolean hasBetweenSixAndNineChars(String password) {
        if (password.length() >= 6 && password.length() <= 9)
            return true;
        else
            return false;
    }

    /**
     * @param password
     * @return boolean
     * @throws WeakPasswordException
     */

    static boolean isWeakPassword(String password) throws WeakPasswordException
    {
        try
        {
            if (!( hasBetweenSixAndNineChars(password)) && isValidPassword(password))
                return false;
        }
        catch (Exception e)
        {
            throw new WeakPasswordException();
        }
        throw new WeakPasswordException();
    }


    /**
     * @param password
     * @return ArrayList
     *
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> password) {

        ArrayList<String> array= new ArrayList<String>();

        for (String i : password) {
            try{
                isValidPassword(i);
            }

            catch( Exception e) {
                array.add(i + " " + e.getMessage());
            }
        }
        return array;
    }
}