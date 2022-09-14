import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Tariq Shaath
 *
 */
public class PasswordCheckerTest_STUDENT {
    ArrayList<String> passwords;

    @Before
    public void setUp() throws Exception {
        String[] str={"123XX22$8", "majayda2001#","8WIZ@", "trix8675","hockey20","x3fTw", "AsemTariqqq#", "RRxx33", "LondonActon", "XXXzz#123"};
               passwords=new ArrayList<String>();
        passwords.addAll(Arrays.asList(str));

    }

    @After
    public void tearDown() throws Exception {
        passwords=null;

    }

    /**
     * Test if the password is less than 6 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testIsValidPasswordTooShort()
    {
        try{
            assertTrue(PasswordCheckerUtility.isValidPassword("cbcNA"));
            assertTrue("Did not throw lengthException",false);
        }
        catch(LengthException e)
        {
            assertTrue("Successfully threw a lengthExcepetion",true);
        }

        catch(Exception e)
        {
            assertTrue("Threw some other exception besides lengthException",false);
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha()
    {
        {
            try{
                assertTrue(PasswordCheckerUtility.isValidPassword("276092"));

                assertTrue("Did not throw NoUpperAlphaException",false);
            }
            catch(NoUpperAlphaException e)
            {
                assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
            }
            catch(Exception e)
            {
                assertTrue("Threw some other exception besides NoUpperAlphaException",false);
            }
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha()
    {
        try{
            assertTrue(PasswordCheckerUtility.isValidPassword("276092T"));

            assertTrue("Did not throw NoLowerAlphaException",false);
        }
        catch(NoLowerAlphaException e)
        {
            assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
        }
        catch(Exception e)
        {
            assertTrue("Threw some other exception besides NoLowerAlphaException",false);
        }
    }
    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsWeakPassword()
    {
        try{

            boolean weakPwd = PasswordCheckerUtility.isWeakPassword("2760#tT");
            assertTrue("Did not throw WeakPassword Exception",false);
        }
        catch(WeakPasswordException e)
        {
            assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            assertTrue("Threw some incorrect exception",false);
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence()
    {
        try{
            assertEquals(true,PasswordCheckerUtility.isValidPassword("276@0ttTTT"));
            assertTrue("Did not throw an InvalidSequenceException",false);
        }
        catch(InvalidSequenceException e)
        {
            assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            assertTrue("Threw some other exception besides an InvalidSequenceException",false);
        }
    }

    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit()
    {
        try{
            PasswordCheckerUtility.hasDigit("tariqSha@t$%T");
        } catch(NoDigitException e) {
            assertTrue("Successfully threw an NoDigitException", true);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Threw some other exception besides a NoDigitException", false);
        }
    }

    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            assertEquals(true, PasswordCheckerUtility.isValidPassword("Tariq2@#345"));
        } catch (NoSpecialCharacterException e) {
            System.out.println(e.getMessage());
            assertTrue("Successfully threw a NoSpecialCharacterException", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
        /**
         * Test the invalidPasswords method
         * Check the results of the ArrayList of Strings returned by the validPasswords method
         */
        @Test
        public void testInvalidPasswords (){
            ArrayList<String> results;
            results = PasswordCheckerUtility.getInvalidPasswords(passwords);

        Scanner scan = new Scanner(results.get(0));
        assertEquals(scan.next(), "123XX22$8");
        String nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("lowercase"));

        scan = new Scanner(results.get(1));
        assertEquals(scan.next(), "majayda2001#");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("sequence"));


        scan = new Scanner(results.get(2));
        assertEquals(scan.next(), "8WIZ@");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("long"));

        scan = new Scanner(results.get(3));
        assertEquals(scan.next(), "trix8675");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("uppercase"));

        scan = new Scanner(results.get(4));
        assertEquals(scan.next(), "hockey20");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("uppercase"));


        scan = new Scanner(results.get(5));
        assertEquals(scan.next(), "x3fTw");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("long"));

        scan = new Scanner(results.get(6));
        assertEquals(scan.next(), "AsemTariqqq");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("digit"));

        scan = new Scanner(results.get(7));
        assertEquals(scan.next(), "RRxx33");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("special"));


        scan = new Scanner(results.get(8));
        assertEquals(scan.next(), "LondonActon");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("digit"));

        scan = new Scanner(results.get(9));
        assertEquals(scan.next(), "XXXzz#123");
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("sequence"));
    }

    }

