package trie;

import trie.common.TrieNode;

public class AutoSearch {

    TrieNode root;

    void put(String key)
    {
        root = put(root,key,0);
    }

    public TrieNode put(TrieNode node,String key,int index)
    {
        char ch = key.charAt(index);

        if(node == null) node = new TrieNode(ch,false);
        if(ch < node.character)  node.left = put(node.left, key, index);
        else if(ch > node.character)  node.right = put(node.right, key, index);
        else if(index < key.length()-1) node.middle = put(node.middle, key, index+1);
        else node.isLeaf = true;

        return node;
    }


    public TrieNode get(TrieNode node,String key,int index)
    {
        char ch = key.charAt(index);

        if(node == null) return null;
        if(ch < node.character)  return get(node.left, key, index);
        else if(ch > node.character) return  get(node.right, key, index);
        else if(index < key.length()-1) return get(node.middle, key, index+1);
        else return node;

    }


    public void autosuggest(String str,TrieNode node)
    {
         if(node == null) return;

        if(node.isLeaf == true)
            System.out.println(str+node.character);

        autosuggest(str, node.left);
        autosuggest(str, node.right);
        autosuggest(str+node.character, node.middle);
    }


    void printSuggestions(String key)
    {
        System.out.println();
        TrieNode start = get(root,key,0);

        if(start!= null)
            autosuggest(key,start.middle);
        else
            System.out.println("Sorry no match for "+'"'+key+'"');;
    }


    public static void main(String[] args)
    {
        AutoSearch ts = new AutoSearch();
        ts.put("prashant");
        ts.put("praveen");
        ts.put("pradeep");
        ts.put("pratap");
        ts.put("pratik");

        ts.put("arvind");
        ts.put("arnab");
        ts.put("anish");
        ts.put("aneeta");
        ts.put("ajay");

        ts.printSuggestions("ar");
        ts.printSuggestions("pra");
        ts.printSuggestions("prat");
        ts.printSuggestions("aj");
        ts.printSuggestions("b");
        ts.printSuggestions("ravi");







    }
}