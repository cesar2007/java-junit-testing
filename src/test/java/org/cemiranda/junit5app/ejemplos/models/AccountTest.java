package org.cemiranda.junit5app.ejemplos.models;

import org.cemiranda.junit5app.ejemplos.exceptions.InsufficientFundsException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountTest {

  Account account;

  @BeforeEach
  void initTestMethod() {
    this.account = new Account("Cesar", new BigDecimal("1000.12345"));
    System.out.println("Initializing the test method");
  }

  @AfterEach
  void tearDown() {
    System.out.println("Finalizing test method");
  }

  @BeforeAll
  static void beforeAll() {
    System.out.println("Initializing the test");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("Finalizing the test");
  }

  @Nested
  @DisplayName("Testing current account attributes")
  class AccountNameBalanceTest {
    @Test
    @DisplayName("the name")
    void testAccountName() {
      account.setPerson("César");
      String expected = "César";
      String actual = account.getPerson();
      assertNotNull(actual, () -> "The account cannot be null");
      assertEquals(expected, actual, "The account name is not as expected");
      assertEquals("César", actual, "Expected must equal actual");
    }

    @Test
    @DisplayName("the balance should not be null, greater than zero, expected value")
    void testAccountBalance() {
      assertNotNull(account.getBalance());
      assertEquals(1000.12345, account.getBalance().doubleValue());
      assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("testing references that are not equal with the equals method")
    void testAccountReference() {
      account = new Account("John Doe", new BigDecimal("8900.9997"));
      Account account2 = new Account("John Doe", new BigDecimal("8900.9997"));
      assertEquals(account2, account);
    }
  }

  @Nested
  class AccountOperationsTest {
    @Test
    void testDebitAccount() {
      account.debit(new BigDecimal(100));
      assertNotNull(account.getBalance());
      assertEquals(900, account.getBalance().intValue());
      assertEquals("900.12345", account.getBalance().toPlainString());
    }

    @Test
    void testCreditAccount() {
      account.credit(new BigDecimal(100));
      assertNotNull(account.getBalance());
      assertEquals(1100, account.getBalance().intValue());
      assertEquals("1100.12345", account.getBalance().toPlainString());
    }

    @Test
    void testTransferMoneyBetweenAccounts() {
      Account sourceAccount = new Account("Jhon Doe donor", new BigDecimal("2500"));
      Account destinationAccount = new Account("Gina Doe recipient", new BigDecimal("1500"));

      Bank bbva = new Bank();
      bbva.setName("BBVA");
      bbva.transfer(sourceAccount, destinationAccount, new BigDecimal(400));
      assertEquals("1900", destinationAccount.getBalance().toPlainString());
      assertEquals("2100", sourceAccount.getBalance().toPlainString());
    }
  }

  @Test
  void insufficientFundsException() {
    Exception exception = assertThrows(InsufficientFundsException.class, () -> {
      account.debit(new BigDecimal(2000));
    });
    String actual = exception.getMessage();
    String expected = "Insufficient funds";
    assertEquals(expected, actual);
  }

  @Test
  @DisplayName("Testing relationships between accounts and the bank with assertAll")
  void testBankAccountRelationship() {
    Account sourceAccount = new Account("Jhon Doe donor", new BigDecimal("2500"));
    Account destinationAccount = new Account("Cesar", new BigDecimal("1500"));

    Bank bbva = new Bank();
    bbva.addAccount(sourceAccount);
    bbva.addAccount(destinationAccount);
    bbva.setName("BBVA");
    bbva.transfer(sourceAccount, destinationAccount, new BigDecimal(400));

    assertAll(
            () -> assertEquals("2200", sourceAccount.getBalance().toPlainString()),
            () -> assertEquals(2, bbva.getAccounts().size()),
            () -> assertEquals("BBVA", sourceAccount.getBank().getName()),
            () -> assertTrue(bbva.getAccounts().stream()
                    .anyMatch(c -> c.getPerson().equals("Cesar"))),
            () -> assertEquals("Cesar", bbva.getAccounts().stream()
                    .filter(c -> c.getPerson().equals("Cesar")).findFirst()
                    .get().getPerson()),
            () -> assertTrue(bbva.getAccounts().stream().anyMatch(c -> c.getPerson()
                    .equals("Cesar")))
    );
  }

  @Nested
  class OperatingSystemTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnlyWindows() {
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testOnlyLinuxMac() {
    }

    @DisabledOnOs(OS.WINDOWS)
    void testNotWindows() {
    }
  }

  @Nested
  class JavaVersionTest {
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyJdk8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void onlyJdk11() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_15)
    void testNotJdk15() {
    }
  }

  @Nested
  class SystemPropertiesTest {
    @Test
    void printSystemProperties() {
      Properties properties = System.getProperties();
      properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = ".*21.*")
    void testJavaVersion() {
    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testOnly64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testNot64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.country", matches = "MX")
    void name() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }
  }

  @Nested
  class EnvironmentVariableTest {
    @Test
    void printEnvironmentVariables() {
      Map<String, String> getenv = System.getenv();
      getenv.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-17.*")
    void testJavaHome() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "14")
    void testProcessors() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
    void testEnv() {
    }
  }

  @Test
  @DisplayName("Test Account Balance Dev")
  void testAccountBalanceDev() {
    boolean isDev = "qa".equals(System.getProperty("ENV"));
    assumeTrue(isDev);
    account = new Account("César", new BigDecimal("1000.12345"));
    assertNotNull(account.getBalance());
    assertEquals(1000.12345, account.getBalance().doubleValue());
    assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
    assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
  }

  @Test
  @DisplayName("Test Account Balance Dev 2")
  void testAccountBalanceDev2() {
    boolean isDev = "dev".equals(System.getProperty("ENV"));
    assumingThat(isDev, () -> {
      assertNotNull(account.getBalance());
      assertEquals(1000.12345, account.getBalance().doubleValue());
      assertFalse(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    });
  }

  @DisplayName("Testing Debit Account Repeat")
  @RepeatedTest(value = 5, name = "Repetition number {currentRepetition} of {totalRepetitions}")
  void testDebitAccountRepeat(RepetitionInfo info) {
    if (info.getCurrentRepetition() == 3) {
      System.out.println("Repetition 3");
    }
    account.debit(new BigDecimal(100));
    assertNotNull(account.getBalance());
    assertEquals(900, account.getBalance().intValue());
    assertEquals("900.12345", account.getBalance().toPlainString());
  }
  @Nested
  class ParameterizedTests {

    @ParameterizedTest(name = "number {index} executing with value {0} - {argumentsWithNames}")
    @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
    void testDebitAccountValueSource(String amount) {
      account.debit(new BigDecimal(amount));
      assertNotNull(account.getBalance());
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest
    @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
    void testDebitAccountCsvSource(String index, String amount) {
      System.out.println(index + " -> " + amount);
      account.debit(new BigDecimal(amount));
      assertNotNull(account.getBalance());
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest
    @CsvSource({"200,100,John,John", "250,200,Pepe,Pepe", "301,300,Maria,Maria", "550,500,Cesar,Cesar", "750,700,Luci,Luci", "1001.12345,1000.12345,Lili,Lili"})
    void testDebitAccountCsvSource2(String balance, String amount, String expected, String actual) {
      System.out.println(balance + " -> " + amount);
      account.setBalance(new BigDecimal(balance));
      account.debit(new BigDecimal(amount));
      account.setPerson(actual);
      assertNotNull(account.getPerson());
      assertEquals(expected, actual);
      assertNotNull(account.getBalance());
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void testDebitAccountCsvFileSource(String amount) {
      account.debit(new BigDecimal(amount));
      assertNotNull(account.getBalance());
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    @ParameterizedTest
    @MethodSource("amountList")
    void testDebitAccountMethodSource(String amount) {
      account.debit(new BigDecimal(amount));
      assertNotNull(account.getBalance());
      assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> amountList() {
      return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }

  }
}