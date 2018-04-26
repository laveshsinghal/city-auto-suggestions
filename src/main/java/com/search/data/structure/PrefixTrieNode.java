package com.search.data.structure;

/**
 * Represents a Node for Prefix Tree data structure. which has few properties: A
 * "label" which is character in the suggestion string. A "word" which could be
 * a suggestion string. "terminal" which define that if the current node ends up
 * in a suggestion word. If it is true which means a suggestion word ends at
 * this node and we store it in the property "word" and if it is false then no
 * word will be stored here. "children" defines the children after this given
 * node. Any node can have max 26 character its children as the alphabets in
 * dictionary So each of them will act as unique character between A-Z
 * 
 * @author Lavesh Singhal
 *
 */
public class PrefixTrieNode {

	// a suggestion string
	private String word;

	// define that if the current node ends up in a suggestion
	private boolean terminal;

	// a character in the suggestion string
	private char label;

	// the children after a given node means if there are more characters in the
	// suggestion string after this node
	private PrefixTrieNode[] children;

	// for alphabets A-Z
	private static int ALPHABET_SIZE = 26;

	public PrefixTrieNode() {

		this.children = new PrefixTrieNode[ALPHABET_SIZE];
	}

	public PrefixTrieNode(char label) {

		this();
		this.label = label;
	}

	public char getLabel() {

		return this.label;
	}

	public boolean getTerminal() {

		return this.terminal;
	}

	public void setTerminal(boolean terminal) {

		this.terminal = terminal;
	}

	public void setWord(String word) {

		this.word = word;
	}

	public String getWord() {

		return this.word;
	}

	public PrefixTrieNode[] getChildren() {

		return this.children;
	}

}
