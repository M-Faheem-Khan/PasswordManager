package main;

import java.util.Hashtable;
import java.util.Map;

public class PasswordManager {
  private final AES aes;
  public final Map<String, String> PasswordVault = new Hashtable<>();

  public PasswordManager(String vaultMasterPassword) {
    aes = new AES(vaultMasterPassword);
  }

  public void addPasswordToVault(String name, String password) {
    PasswordVault.put(name, aes.encrypt(password));
  }

  public String getPasswordFromVault(String name) {
    String encryptedPassword = PasswordVault.get(name);
    if (encryptedPassword == null) {
      return null;
    }
    return aes.decrypt(encryptedPassword);
  }

  public void removePasswordFromVault(String name) {
    PasswordVault.remove(name);
  }

  public int passwordsInVault() {
    return PasswordVault.size();
  }

  public Map<String, String> getAllPasswordsFromVault() {
    Map<String, String> decryptedPasswords = new Hashtable<>();
    for (String key : PasswordVault.keySet()) {
      decryptedPasswords.put(key, getPasswordFromVault(key));
    }
    return decryptedPasswords;
  }
}

// EOF
