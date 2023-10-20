package main;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    String vaultMasterPassword = generateRandomPassword();
    PasswordManager passwordManager = new PasswordManager(vaultMasterPassword);

    // Adding Password to Vault
    passwordManager.addPasswordToVault("Github", "GITHUB_PASSWORD");
    passwordManager.addPasswordToVault("TWITTER", "TWITTER_PASSWORD");
    passwordManager.addPasswordToVault("NETFLIX", "NETFLIX_PASSWORD");

    // Removing Password from Vault
    passwordManager.removePasswordFromVault("Github");

    // Listing All Decrypted Passwords
    Map<String, String> decryptedPasswords = passwordManager.getAllPasswordsFromVault();
    for (String key : decryptedPasswords.keySet()) {
      System.out.println(key + ":" + decryptedPasswords.get(key));
    }
  }

  public static String generateRandomPassword() {
    SecureRandom random = new SecureRandom();
    byte bytes[] = new byte[20];
    random.nextBytes(bytes);
    Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
    return encoder.encodeToString(bytes);
  }
}

// EOF
