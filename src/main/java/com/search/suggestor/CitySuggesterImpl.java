package com.search.suggestor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.search.data.structure.PrefixTrieNode;

/**
 * Implementation for CitySuggester.
 * 
 * @author Lavesh Singhal
 *
 */
public class CitySuggesterImpl implements CitySuggestor {

	private PrefixTrieNode root;

	public CitySuggesterImpl() {
	}
	
	public CitySuggesterImpl(PrefixTrieNode root) {
		this.root = root;
	}

	@Override
	public List<String> retrieveCitySuggestions(String cityInitials, int suggestionCount) {

		char[] cArray = cityInitials.toUpperCase().toCharArray();
		PrefixTrieNode tempNode = this.root;
		PrefixTrieNode tn = null;
		int index = 0;
		
		//if no root node set return null
		if(null==tempNode){
			return null;
		}else{
			do {
				tn = tempNode.getChildren()[cArray[index] - 'A'];
				
				//if there is no node till we reach last character of cityInitials then return null
				if (tn == null) {
					return null;
				}

				index++;
				tempNode = tn;
			} while (index < cArray.length);
		}
		
		List<String> words = new ArrayList<String>();
		Deque<PrefixTrieNode> DQ = new ArrayDeque<PrefixTrieNode>();
		DQ.addLast(tempNode);
		
		//using a deque to traverse all the child nodes 
		while (!DQ.isEmpty()) {

			if (words.size() == suggestionCount) {
				break;
			}
			PrefixTrieNode first = DQ.removeFirst();
			if (first.getTerminal()) {
				words.add(first.getWord());
			}

			for (PrefixTrieNode n : first.getChildren()) {
				if (n != null) {
					DQ.add(n);
				}
			}
		}

		return words;
	}
	
	public void setRoot(PrefixTrieNode root){
	
		this.root=root;
	}
	
}
