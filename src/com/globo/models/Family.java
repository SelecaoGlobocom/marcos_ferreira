package com.globo.models;

import java.util.List;

public class Family {
	
	private Parent parent;
	private List<Son> sons;
	
	public Family(Parent parent, List<Son> sons) {
		this.parent = parent;
		this.sons = sons;
	}

	public Parent getParent() {
		return parent;
	}

	public List<Son> getSons() {
		return sons;
	}

}
