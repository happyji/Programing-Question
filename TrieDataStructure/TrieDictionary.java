class Constant
{
    final static int ALPHABET_SIZE = 26;
    final static int NON_VALUE = -1;
}

class TrieNode
{
    boolean isLeafNode;
    int value;
    TrieNode[] children;

    TrieNode(boolean isLeafNode, int value)
    {
        this.value = value;
        this.isLeafNode = isLeafNode;
        children = new TrieNode[Constant.ALPHABET_SIZE];
    }

    public void markAsLeaf(int value)
    {
        this.isLeafNode = true;
        this.value = value;
    }
}

public class TrieDictionary {

    TrieNode root;

    TrieDictionary()
    {
        this.root = new TrieNode(false, Constant.NON_VALUE);
    }

    private int getIndex(char ch)
    {
        return ch - 'a';
    }

    public int search(String key)
    {
        if (key == null)
        {
            return Constant.NON_VALUE;
        }

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while ((currentNode != null) && (charIndex < key.length()))
        {
            int childIndex = getIndex(key.charAt(charIndex));
            currentNode = currentNode.children[childIndex];
            charIndex += 1;

        }

        if (currentNode != null)
        {
            return currentNode.value;
        }

        return  Constant.NON_VALUE;
    }

    public void insert(String key, int value)
    {
        // null keys are not allowed
        if (key == null) return;

        key = key.toLowerCase();

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while (charIndex < key.length())
        {
            int childIndex = getIndex(key.charAt(charIndex));

            if (currentNode.children[childIndex] == null)
            {
                currentNode.children[childIndex] = new TrieNode(false, Constant.NON_VALUE);
            }

            currentNode = currentNode.children[childIndex];
            charIndex  += 1;
        }


        currentNode.markAsLeaf(value);
    }

    public static void main(String[] args)
    {
        TrieDictionary tr = new TrieDictionary();

        tr.insert("aab", 3);
        tr.insert("aac",4);
        tr.insert("aart",1);
        int value = tr.search("aarte");
        System.out.println(value);

    }
}
