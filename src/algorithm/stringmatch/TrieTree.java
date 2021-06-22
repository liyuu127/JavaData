package algorithm.stringmatch;

/**
 * @author liyu
 * date 2021/6/21 19:23
 * description
 */
public class TrieTree {
    class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }


    private TrieNode root = new TrieNode('/'); // ´æ´¢ÎÞÒâÒå×Ö·û


    public void insert(char[] text) {
        int length = text.length;
        TrieNode head = this.root;
        for (int i = 0; i < length; i++) {
            int index = text[i] - 'a';
            if (head.children[index] == null) {
                TrieNode trieNode = new TrieNode(text[i]);
                head.children[index] = trieNode;
            }
            head = head.children[index];
        }
        head.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode head = this.root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (head.children[index] == null) {
                return false;
            }
            head = head.children[index];
        }
        return head.isEndingChar;

    }
}