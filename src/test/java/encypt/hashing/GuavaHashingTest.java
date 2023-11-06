package encypt.hashing;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static com.google.common.hash.Hashing.sha256;

/**
 * @author liyu
 * date 2023/11/6 15:28
 * description:
 */
public class GuavaHashingTest {

    @Test
    public void test_sha256() {
        HashFunction sha256 = sha256();
        String id = "24A89B51B8ED7EB6FAE7CC2E713600F1";
        HashCode hashCode = sha256.hashString(id, StandardCharsets.UTF_8);
        String sha256String = hashCode.toString();
        System.out.println("sha256String = " + sha256String);
        String pre16 = sha256String.substring(0, 16);
        System.out.println("ǰ16λ = " + pre16);
        long seq = Long.parseLong(pre16, 16);
        System.out.println("תʮ���� = " + seq);
        System.out.println("ȡ�� = " + seq%704);

    }
}
