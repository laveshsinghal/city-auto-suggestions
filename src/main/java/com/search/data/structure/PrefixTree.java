package com.search.data.structure;

/**
 * This class uses ordered tree data structure algorithm.
 * 
 * which creates a tree using prefixTreeNode. In this tree the root element
 * has the label character is ' ' which is empty. Then each node which have
 * children will have children in between A-Z.This is an ordered tree data
 * structure that is used to store a dynamic set or associative array where the
 * keys are usually strings. Unlike a binary search tree, no node in the tree
 * stores the key associated with that node; instead, its position in the tree
 * defines the key with which it is associated. All the descendants of a node
 * have a common prefix of the string associated with that node, and the root is
 * associated with the empty string.
 * 
 * example: If in the reference file HOME, HELP and HEAP are available as reference
 * 			 /suggestion strings then they would be added in this digital tree like 
 * 			below:
 * 
 * 					(' ')
 * 					  |
  *                 ('H')
  *                 /   \ 
  *             ('O')    ('E')
  *             /         /  \
  *           ('M')   ('A')  ('L')
  *           /        /       \
  *         ('E')    ('P')     ('P')
  *         
  *         
  *         So if the initials for the search are HE then all the paths would be traversed
  *         for all suggestions from node label 'E'. here only two suggestions are available
  *         which are HELP and HEAP
  *         
  *         
 * @author Lavesh Singhal
 *
 */
public class PrefixTree {

	private PrefixTrieNode root;
	private static final String VALID_CITY_FORMAT = "[a-zA-Z]+";
	private static final char CHILD_LABEL_A = 'A';

	/**
	 * creates a root node initialized with label ' '
	 */
	public PrefixTree() {
		this.root = new PrefixTrieNode(' ');
	}

	/**
	 * return root node.
	 * @return PrefixTrieNode
	 */
	public PrefixTrieNode getRoot() {

		return root;
	}

	/**
	 * adds a suggestion string in the prefix tree.
	 * @param data
	 * @return
	 */
	public boolean addData(String data) {

		boolean dataAdded = true;
		
		//return if city name is not well formed or illegal formatted string present in the reference file
		if (!data.matches(VALID_CITY_FORMAT)) {
			return false;
		}
		char[] dataArray = data.toUpperCase().toCharArray();
		PrefixTrieNode tempNode = root;
		PrefixTrieNode tn = null;
		int index = 0;

		do {
			tn = tempNode.getChildren()[dataArray[index] - CHILD_LABEL_A];
			if (tn != null) {
				tempNode = tn;
				index++;
				
				//If reached to a node in the tree where the city name ends then add it as a terminal word and return
				if (index >= data.length()) {
					tempNode.setTerminal(true);
					tempNode.setWord(data);
					return true;
				}
			}
		} while (tn != null);
		
		/**
		 * Traverse until all the remaining characters in the city names are not added as separate nodes in the tree
		 */
		for (; index < dataArray.length; index++) {
			try {
				tempNode.getChildren()[dataArray[index] - CHILD_LABEL_A] = new PrefixTrieNode(dataArray[index]);
				tempNode = tempNode.getChildren()[dataArray[index] - CHILD_LABEL_A];
			} catch (Exception e) {
				System.out.println("Exception occured in adding city : "+data+" at index : "+tempNode.getChildren()[dataArray[index] - CHILD_LABEL_A]);
			}
		}
		
		//set the city name as a terminal word
		tempNode.setTerminal(true);
		tempNode.setWord(data);

		return dataAdded;
	}
}
