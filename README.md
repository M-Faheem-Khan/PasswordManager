# PasswordManager

The goal of this project is to try out the Fuzzing for Java Applications using 
[Jazzer](https://github.com/CodeIntelligenceTesting/jazzer).  
- [Youtube: Fuzzing Java with Jazzer](https://www.youtube.com/watch?v=YRporP5p1pc&ab_channel=JavaUserGroupSwitzerland)
- [Youtube: How to Keep your Web Applications Secure: Everything you need to know about Fuzzing](https://www.youtube.com/watch?v=bhrt6Bf240U&ab_channel=CodeIntelligence)
---
### About
**What is this application?**  
In Memory Password Manager written in Java uses Maps to store encrypted passwords in memory. Uses AES to encrypt all keys. See 
[Main.java](https://github.com/M-Faheem-Khan/PasswordManager/blob/main/src/main/Main.java) on how it works.

### Fuzzing
**What is fuzzing or fuzz testing?**  
An application testing technique that where invalid, unexpected or random data is used as input in an attempt to crash,
invoke exceptions and potential memory leaks. See [Wikipedia](https://en.wikipedia.org/wiki/Fuzzing) article on fuzzing.

**What types of applications can be Fuzzed?**  
Anything really that takes in an input. E.g. CLI applications, REST or SOAP services. 

**Why use Jazzer?**  
- Jazzer allows automated fuzzing which is greatly reduces the time to fuzz an application. 
- Easy to integrate with application
- Coverage Report using JUnit
- Tests for the OWASP & Other common vulnerabilities


[//]: # (EOF)