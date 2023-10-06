package test;

import main.PasswordManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Hashtable;
import java.util.Map;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;


class PasswordManagerTest {
    private final String MasterPassword = "MasterPassword123!$";
    private final PasswordManager passwordManager = new PasswordManager(MasterPassword);

    @BeforeEach
    public void Setup() {
        // Populating Password Vault
        passwordManager.addPasswordToVault("Test1", "ADD-THIS-KEY!");
        passwordManager.addPasswordToVault("Test2", "ALSO_ADD-THIS-KEY!");
    }

    @Test
    void addPasswordToVaultTest() {
        passwordManager.addPasswordToVault("Test3", "DO-NOT-FORGET-TO-ADD-THIS-KEY-AS-WELL!");
        Assertions.assertEquals(3, passwordManager.passwordsInVault());
    }

    @Test
    void getPasswordFromVaultTest() {
        Assertions.assertEquals("ADD-THIS-KEY!", passwordManager.getPasswordFromVault("Test1"));
    }

    @Test
    void removePasswordFromVaultTest() {
        passwordManager.removePasswordFromVault("Test3");
        Assertions.assertEquals(2, passwordManager.passwordsInVault());
    }

    @Test
    void getAllPasswordsFromVaultTest() {
        Map<String, String> passwordsInVault = new Hashtable<>();
        passwordsInVault.put("Test1", "ADD-THIS-KEY!");
        passwordsInVault.put("Test2", "ALSO_ADD-THIS-KEY!");
        Assertions.assertEquals(passwordsInVault, passwordManager.getAllPasswordsFromVault());
    }

    @FuzzTest
    void addPasswordToVaultFuzzTest(FuzzedDataProvider data) {
        passwordManager.addPasswordToVault(data.consumeString(2147483647), data.consumeString(2147483647));
        Assertions.assertEquals(4, passwordManager.passwordsInVault());
    }

    @FuzzTest
    void getPasswordFromVaultTest(FuzzedDataProvider data) {
        String fuzzString = data.consumeString(2147483647);
        Assertions.assertEquals(fuzzString, passwordManager.getPasswordFromVault(fuzzString));
    }

    @FuzzTest
    void removePasswordFromVaultFuzzTest(FuzzedDataProvider data) {
        passwordManager.removePasswordFromVault(data.consumeString(2147483647));
        Assertions.assertEquals(3, passwordManager.passwordsInVault());
    }
}

































