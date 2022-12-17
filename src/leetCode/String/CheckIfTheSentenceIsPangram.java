package leetCode.String;

/**
 * @author liyu
 * date 2022/12/13 9:27
 * description 1832. �жϾ����Ƿ�Ϊȫ��ĸ��
 * ȫ��ĸ�� ָ����Ӣ����ĸ����ÿ����ĸ����һ�εľ��ӡ�
 * ����һ������СдӢ����ĸ��ɵ��ַ��� sentence �������ж� sentence �Ƿ�Ϊ ȫ��ĸ�� ��
 * ����ǣ����� true �����򣬷��� false ��
 * ʾ�� 1��
 * ���룺sentence = "thequickbrownfoxjumpsoverthelazydog"
 * �����true
 * ���ͣ�sentence ����Ӣ����ĸ����ÿ����ĸ����һ�Ρ�
 * ʾ�� 2��
 * ���룺sentence = "leetcode"
 * �����false
 * ��ʾ��
 * 1 <= sentence.length <= 1000
 * sentence ��СдӢ����ĸ���
 */
public class CheckIfTheSentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {

        int mask = 0;
        int n = sentence.length();

        for (int i = 0; i < n; i++) {
            int j = sentence.charAt(i) - 'a';
            mask |= 1 << j;
        }
        return mask==67108863;
    }

    public static void main(String[] args) {
        int i = Integer.parseInt("11111111111111111111111111", 2);
        System.out.println("i = " + i);
        System.out.println("checkIfPangram(\"thequickbrownfoxjumpsoverthelazydog\") = " + checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
