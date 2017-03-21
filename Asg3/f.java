import java.util.*;

// Author: Kevin Dalle
// Copyright 2016

public class f{
	public static void main(String args[]){
		System.out.println("Result for entered numbers");
		String x = args[0];
		Integer a = Integer.parseInt(x) + 1;
		String y = args[1];

		ArrayList<String> vars = new ArrayList<String>();

		vars.add(x);
		vars.add(y);
		vars.add(a.toString());

		ActivationRecord myRecord = new ActivationRecord(vars);

		Integer retVal = 0;

		if (Integer.parseInt(x) == 0){
			retVal = g(y,myRecord);
		}
		else{
			Integer newX = Integer.parseInt(x) - 1;

			Integer xForG = fFun(newX.toString(),y);
			
			retVal = a + g(xForG.toString(), myRecord);
		}

		System.out.println("f(" + x + "," + y + ") = " + retVal);

	}

	public static Integer fFun(String x,String y){
		Integer a = Integer.parseInt(x) + 1;

		ArrayList<String> vars = new ArrayList<String>();

		vars.add(x);
		vars.add(y);
		vars.add(a.toString());

		ActivationRecord myRecord = new ActivationRecord(vars);

		Integer retVal = 0;

		if (Integer.parseInt(x) == 0){
			retVal = g(y,myRecord);
		}
		else{
			Integer newX = Integer.parseInt(x) - 1;

			Integer xForG = fFun(newX.toString(),y);

			retVal = a + g(xForG.toString(), myRecord);
		}

		return retVal;
	}

	public static Integer g(String n, ActivationRecord link){
		if (Integer.parseInt(n) == 0){
			return 0;
		}
		else{
			Integer y = Integer.parseInt(link.getVars().get(1));
			Integer x = Integer.parseInt(link.getVars().get(0));
			Integer a = x + y;

			ArrayList<String> vars = new ArrayList<String>();

			vars.add(n.toString());
			vars.add(a.toString());

			ActivationRecord myRecord = new ActivationRecord(vars, link);

			Integer newN = Integer.parseInt(n) - 1;

			Integer retVal = h(newN.toString(), myRecord);
			return retVal;
		}
	}

	public static Integer h(String k, ActivationRecord link){
		if (Integer.parseInt(k) == 0){
			return 0;
		}
		else{
			Integer n = Integer.parseInt(link.getVars().get(0));

			Integer a = Integer.parseInt(link.getVars().get(1));

			Integer newN = n -1;

			Integer retVal = a + n + g(newN.toString(), link.getLink());

			return retVal;
		}
	}

}

