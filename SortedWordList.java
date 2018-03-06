public class main(String[] args) {
import java.util.ArrayList;

public class SortedWordList extends ArrayList<String>
{
    private int size;
    
    public int size(){
        return size;
    }
    
    public SortedWordList() {
        super();
    }
    
    public SortedWordList(int size) {
        super(size);
        this.size = size;
        for(int i = 0; i<size; i++) {
            super.add("");
        }
    }
    
    public boolean contains(String s) {
        return indexOf(s) >= 0;
    }
    
    public int indexOf(String target) {
        int left = 0, right = size() - 1;

        while (left <= right)
        {

            int middle = (left + right) / 2;

            int diff = target.compareTo(get(middle));

            if (diff > 0)   
                left = middle + 1;
            else if (diff < 0)   
                right = middle - 1;
            else  
                return middle;
        }

        return -1;
    }
    
    public String set(int i, String word) {
        if (i==0 && word.compareTo(get(i+1)) < 0  //added condition for i==0
            || i==size-1 && word.compareTo(get(i-1)) > 0  //added condition for i==size
            || i>0 && i<size-1 && word.compareTo(get(i-1)) > 0  //added i>0 
            && word.compareTo(get(i+1)) < 0) 
        {
            return super.set(i, word);
        }
        else {
            throw new IllegalArgumentException("word=" + word + " i=" + i);
        }
    }
    
    public void add(int i, String word) {
        if (i==0 && word.compareTo(get(i)) < 0  //added condition for i==0
            || i==size && word.compareTo(get(i-1)) > 0  //added condition for i==size
            || i>0 && word.compareTo(get(i-1)) > 0  //added i>0
            && word.compareTo(get(i)) < 0)
        {
            size += 1;
            super.add(i, word);
        }
        else {
            throw new IllegalArgumentException("word=" + word + " i=" + i);
        }
    }
    
    public boolean add(String word) {
        int left = 0, right = size() - 1;
        int middle = (left + right) / 2;

        while (left <= right)
        {

            middle = (left + right) / 2;

            int diff = word.compareTo(get(middle));

            if (diff > 0)   
                left = middle + 1;
            else if (diff < 0)   
                right = middle - 1;
            else  
                return false;
        }
        
        size += 1;
        super.add(left, word);  //changed middle to left
        return true;
    }
    
    public String remove(int i) {
        size -= 1;
        return super.remove(i);
    }
    
    public boolean remove(String word) {
        size -= 1;
        return super.remove(word);
    }
    
    public void merge(SortedWordList additionalWords) {
        for(String word : additionalWords) {
            add(word);
        }
    }
    
}
}