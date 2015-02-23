# SortedWordList

In this lab, you will write a class <code>SortedWordList</code>, which represents a list of words, sorted alphabetically (case blind). <code>SortedWordList</code> should extend (be a subclass of) <code>ArrayList\<String\></code>. You have to redefine several of <code>ArrayList</code>'s methods to keep the list always alphabetically sorted and with no duplicates words.

<ol>
<li>Create an instance variable called <code>size</code> and redefine the method <code>size()</code> so that it will return the instance variable.
<li>Provide a no-args constructor and a constructor with one <code>int</code> parameter, the initial capacity of the list.
<li>Redefine the <code>contains</code> and <code>indexOf</code> methods: make them use Binary Search.
<li>Redefine the <code>set(i, word)</code> method so that it first checks whether word fits alphabetically between the (i-1)-th and (i+1)-th elements and is not equal to either of them. If this is not so, <code>set</code> should throw an <code>IllegalArgumentException</code> as follows:
<br>
<pre>
<code>if (...) 
  throw new IllegalArgumentException("word=" + word + " i=" + i);</code>
</pre>
<li>Redefine the <code>add(i, word)</code> method so that it first checks whether <code>word</code> fits alphabetically between the (i-1)-th and i-th elements and is not equal to either of them. If this is not so, throw an <code>IllegalArgumentException</code>. Make sure to add 1 to the instance variable <code>size</code> if this method succeeds.
<li>Redefine the <code>add(word)</code> method so that it inserts <code>word</code> into the list in alphabetical order. If word is already in the list, <code>add</code> should not insert it and should return <code>false</code>; otherwise, if successful, <code>add</code> should return <code>true</code>. Use Binary Search to locate the place where word should be inserted. Make sure to add 1 to the instance variable <code>size</code> if this method succeeds.
<li>Redefine the <code>remove</code> methods to decrement the instance variable <code>size</code> by 1 for each removal.
<li>Define a new method <code>merge(SortedWordList additionalWords)</code>. This method should insert into this list in alphabetical order all the words from <code>additionalWords</code> that are not already in this list. <code>merge</code> should be efficient. You may not use any temporary arrays or lists. Each element from this list should move at most once, directly into its proper location. 
<ul>
<li>One way to achieve this while avoiding an <code>IndexOutOfBoundsException</code>, you first need to add some dummy elements to the list. Find the number of additional words to be inserted. To do that efficiently, do a "tentative merge" without moving any elements. Then save the current size of the list and append to it the required number of arbitrary strings. Call <code>super.add("")</code> to append an empty string at the end of the list. Now merge the lists, starting at the end of each list and at the end of the added space. At each step decide which of the two lists should supply the next element for the next vacant location.
<li>Another way, possibly a much more easier way, is to simply call the <code>add</code> method with each element in the second array.
</ul>
</ol>
Combine your class with <code>SortedListTest.java</code> to test your program.
