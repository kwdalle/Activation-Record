import java.util.*;

// Author: Kevin Dalle
// Copyright 2016

class ActivationRecord{
	ArrayList<String> variables = new ArrayList<String>();
	ActivationRecord nestingLink;

	public ActivationRecord(ArrayList<String> vars){
		this.variables = vars;
		this.nestingLink = null;
	}

	public ActivationRecord(ArrayList<String> vars, ActivationRecord link){
		this.variables = vars;
		this.nestingLink = link;
	}

	public ArrayList<String> getVars(){
		return this.variables;
	}

	public ActivationRecord getLink(){
		return this.nestingLink;
	}
}
