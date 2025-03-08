class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.addWord(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
}

class Trie {
    Node head;
    Trie(){
        head = new Node();
    }
    public void addWord(String word) {
        Node curr = head;
        for(char c : word.toCharArray()){
            if(curr.getNode(c)==null){
                curr.addNode(c);
            }
            curr = curr.getNode(c);
        }
        curr.setFlag();
    }

    public boolean search(String word){
        Node curr = head;
        return search(curr, word);
    }

    public boolean search(Node node, String word){
        Node curr = node;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(c=='.'){
                for(Node child : curr.child){
                    if(child != null && search(child, word.substring(i+1))){
                        return true;
                    }
                }
                return false;
            }
            if(curr.getNode(c)==null) return false;
            curr = curr.getNode(c);
        }
        return curr.getFlag();
    }
}

class Node {
    Node[] child;
    boolean flag;
    Node(){
        child = new Node[26];
        flag = false;
    }
    Node getNode(char c){
        return child[c-'a'];
    }
    void addNode(char c){
        child[c-'a'] = new Node();
    }
    void setFlag(){
        flag = true;
    }
    boolean getFlag(){
        return flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */