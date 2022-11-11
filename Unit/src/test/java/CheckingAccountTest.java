import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


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

        assertThat(sut.balance, equalTo(expected));
    }

    @Test
    public void addMoneyTest(){

        int amount = 350;
        boolean expected = false;

        assertThat(expected, not(sut.addMoney(amount)));

    }

    @Test
    public void transferTest(){

        int amount = 5500, expected = 500;

        sut.transfer(sut2, amount);

        assertThat(sut2.balance, equalTo(expected));
    }
}