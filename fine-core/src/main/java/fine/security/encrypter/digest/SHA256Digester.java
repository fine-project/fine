package fine.security.encrypter.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ShA256のEncrypter。
 * @author masanii15
 * @since 1.0
 */
public class SHA256Digester implements MessageDigester {

    @Override
    public byte[] digest(byte[] bytes) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = digest.digest(bytes);
        return hash;
    }

}
