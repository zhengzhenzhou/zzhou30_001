package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * This is an test class for a simple class that represents a string, defined
 * as a sequence of characters.
 *
 * You should implement your tests in this class.  Do not change the test names.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    //Test Purpose: This is the first instructor example test.
    @Test
    public void testCountDuplicates1() {
        mycustomstring.setString("People are sleeping... Zzz.");
        assertEquals(4, mycustomstring.countDuplicates());
    }

    @Test
    // This test checks whether 2 spaces will be recognized for duplicates
    public void testCountDuplicates2() {
        mycustomstring.setString("Zhengzhen  Zhou");
        assertEquals(1, mycustomstring.countDuplicates());
    }

    @Test
    // This test checks whether it will return 0 when there is only one character
    public void testCountDuplicates3() {
        mycustomstring.setString("g");
        assertEquals(0, mycustomstring.countDuplicates());
    }

    @Test
    // This test checks whether it will return 0 when there is only one number
    public void testCountDuplicates4() {
        mycustomstring.setString("4");
        assertEquals(0, mycustomstring.countDuplicates());
    }

    @Test
    // This test checks whether it will return 0 if the string is null
    public void testCountDuplicates5() {
        MyCustomString string = new MyCustomString();
        assertEquals(0, mycustomstring.countDuplicates());
    }

    @Test
    // This test checks whether it will return 0 if the string is empty
    public void testCountDuplicates6() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countDuplicates());
    }


    //Test Purpose: This is the second instructor example test.
    @Test
    public void testAddDigits1() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("5678!!! H7y, l7t'9 put 94me d505ts in this 9tr5n0!55!5", mycustomstring.addDigits(4, true));
    }

    //Test Purpose: This the third instructor example test.
    @Test
    public void testAddDigits2() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        assertEquals("7890!!! H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!7", mycustomstring.addDigits(4, false));
    }

    //This test checks whether it returns an empty string if given empty string
    @Test
    public void testAddDigits3() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.addDigits(8, true));
    }

    // This test checks whether it properly handles NullPointerException error
    @Test(expected = NullPointerException.class)
    public void testAddDigits4() {
        MyCustomString string = new MyCustomString();
        mycustomstring.addDigits(2, false);
    }

    // This test checks whether it handles IllegalArgumentException error when n>9, while positive is true
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits5() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        mycustomstring.addDigits(19, true);
    }

    // This test checks whether it handles IllegalArgumentException error when n>9, while positive is false
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits6() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        mycustomstring.addDigits(19, false);
    }

    // This test checks whether it handles IllegalArgumentException error when n<=0, while positive is true
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits7() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        mycustomstring.addDigits(-5, true);
    }

    // This test checks whether it handles IllegalArgumentException error when n<=0, while positive is false
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigits8() {
        mycustomstring.setString("1234!!! H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!1");
        mycustomstring.addDigits(-5, false);
    }

    // This test checks whether it'll report the NullPointerException error when both the NullPointerException and IllegalArgumentException errors happen
    @Test(expected = NullPointerException.class)
    public void testAddDigits9() {
        MyCustomString string = new MyCustomString();
        mycustomstring.addDigits(-5, false);
    }

    // This test checks whether things will work when there is no number at all, just letters
    @Test
    public void testAddDigits10() {
        mycustomstring.setString("alfnalvbaekruaehgfjakhj");
        assertEquals("alfnalvbaekruaehgfjakhj", mycustomstring.addDigits(4, false));
    }

    // This test checks whether things will work when there is no number at all, just signs
    @Test
    public void testAddDigits11() {
        mycustomstring.setString("^^$#@@#$%&*(");
        assertEquals("^^$#@@#$%&*(", mycustomstring.addDigits(5, false));
    }

    //This test continues to check whether things go well when there is just numbers
    @Test
    public void testAddDigits12() {
        mycustomstring.setString("543254768767809766645");
        assertEquals("210921435434576433312", mycustomstring.addDigits(7, true));
    }


    //Test Purpose: This is the fourth instructor example test.
    @Test
    public void testFlipLetttersInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(18, 30);
        assertEquals("H3y, l3t'5 put 50ni s161tD em this 5tr1n6!11!!", mycustomstring.getString());
    }

    //Test Purpose: This is an instructor example test to demonstrate testing for an exception.
    @Test(expected = NullPointerException.class)
    public void testFlipLetttersInSubstring2() {
        mycustomstring.flipLetttersInSubstring(200, 100);
    }

    //This test checks whether it properly handles MyIndexOutOfBoundsException error when startPosition <= 0
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring3() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(-5, 10);
    }

    //This test checks whether it properly handles MyIndexOutOfBoundsException error when endPosition > the length
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring4() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(5, 300);
    }

    //This test checks whether it properly handles MyIndexOutOfBoundsException error when endPosition > the length and start position <=0
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testFlipLetttersInSubstring5() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.flipLetttersInSubstring(-5, 300);
    }

    //This test checks whether it properly reports NullPointerException error even when MyIndexOutOfBoundsException error exist as well
    @Test(expected = NullPointerException.class)
    public void testFlipLetttersInSubstring6() {
        mycustomstring.flipLetttersInSubstring(-5, 10);
    }

    //This test checks whether it handles IllegalArgument Exception error properly
    @Test(expected = IllegalArgumentException.class)
    public void testFlipLetttersInSubstring7() {
        mycustomstring.setString("dh7636%$%jknqi965$%f2qCijoi^&^543");
        mycustomstring.flipLetttersInSubstring(20, 10);
    }

    //This test checks whether it properly reports NullPointerException error when IllegalArgumentException error exist as well
    @Test(expected = NullPointerException.class)
    public void testFlipLetttersInSubstring8() {
        mycustomstring.flipLetttersInSubstring(20, 10);
    }

    //This test checks whether it returns 2 spaces when given 2 spaces
    @Test
    public void testFlipLetttersInSubstring9() {
        mycustomstring.setString("  ");
        mycustomstring.flipLetttersInSubstring(1, 2);
        assertEquals("  ", mycustomstring.getString());
    }

    //This test checks whether it would still run when start and end point is the same
    @Test
    public void testFlipLetttersInSubstring10() {
        mycustomstring.setString("dh7636%$%jknqi965$%f2qCijoi^&^543");
        mycustomstring.flipLetttersInSubstring(10, 10);
        assertEquals("dh7636%$%jknqi965$%f2qCijoi^&^543", mycustomstring.getString());
    }
}