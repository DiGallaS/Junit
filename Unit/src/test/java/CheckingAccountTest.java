import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class CheckingAccountTest {
    CheckingAccount sut;
    CheckingAccount sut2;

    @BeforeEach
    public void init(){
        System.out.println("Test started");
        sut = new CheckingAccount(5000);
        sut2 = new CheckingAccount(500);
    }

    @BeforeAll
    public static void started() {
        System.out.println("Tests started");
    }

    @AfterEach
    public void finished(){
        System.out.println("Test completed");
        sut = null; sut2 = null;
    }


    @AfterAll
    public static void finishedAll(){
        System.out.println("Tests completed");
    }


    @Test
    public void payTest(){

        int amount = 500, expected = 4500;

        sut.pay(amount);

        assertEquals(expected, sut.balance);
    }

    @Test
    public void addMoneyTest(){

        int amount = 350;

        assertTrue(sut.addMoney(amount));
    }

    @Test
    public void transferTest(){

        int amount = 5500, expected = 500;

        sut.transfer(sut2, amount);

        assertEquals(expected, sut2.balance);
    }
}