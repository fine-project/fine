package fine.security.encrypter.digest;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.junit.jupiter.api.Test;

import com.fineframework.security.encrypter.digest.SHA256Digester;

public class SHA256DigesterTest {

    @Test
    public void testSha256() throws UnsupportedEncodingException{
        String password = "password0";
        SHA256Digester sha256Digester = new SHA256Digester();
        
        byte[] digest = sha256Digester.digest(password.getBytes("UTF-8"));
        
        System.out.println(DatatypeConverter.printHexBinary(digest));
    }

}
