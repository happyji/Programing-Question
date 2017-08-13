package trie.common;

/**
 * Created by prashant on 13/08/17.
 */
public class TrieNode
{
     public char character;
     public boolean isLeaf;
     public TrieNode left,middle,right;

    public TrieNode(char c,boolean isleaf)
    {
        character = c;
        isLeaf = isleaf;
    }
}
