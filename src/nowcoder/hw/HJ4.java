package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 16:16
 * description �ַ����ָ�
 */
public class HJ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextLine()) { // ע�� while ������ case
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();//�μ��ַ����������Ľ����﷨
            sb.append(str);//�ַ����������ļ���
            int size = str.length();
            int addZero = 8 - size%8;//addzero�Ŀ���ֵ����8
            while((addZero > 0)&&(addZero<8)){//ע��߽���ڣ�����addzero=8
                sb.append("0");//ʹ�á����򡰡�����
                addZero--;
            }
            String str1 = sb.toString();
            while(str1.length()>0){
                System.out.println(str1.substring(0,8));
                str1 = str1.substring(8);
            }

        }
    }
}
