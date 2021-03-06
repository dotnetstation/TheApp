package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    private List<IQueryProcessor> processors = new ArrayList<IQueryProcessor>();

    public QueryProcessor() {
        processors.add(new PlusMultiplyProcessor());
        processors.add(new FibonacciProcessor());
        processors.add(new BananaProcessor());
    }

    public String process(String query) {
    	
    	System.out.println("Our query is: " + query);
    	
    	
        if (query.contains("programming")) {
            return "Computer programming is the comprehensive process that leads from an original " 
                   + "formulation of a computing problem to executable programs.";
        }
        else
            if (query.contains("football")) {
                return "The best player in the world is ronaldo...after neymar.";
            }
            else
                if (query.contains("cheese")) {
                    return "Cheese is very good";
                }
                else
                    if (query.contains("largest")) {
                        return processLargest(query);
                    }
                    else
                        if (query.contains("square and a cube")) {
                            return processSquareCube(query);
                        }
                  
        for (IQueryProcessor IQueryProcessor : processors) {
            if (IQueryProcessor.matchRequest(query)) {
                return IQueryProcessor.result(query);
            }
        }
        
    	System.out.println("<<<ACHTUNG!!!>> THIS IS NOT MANAGED: " + query);

        return "";
    }
    

	private String processSquareCube(String query) {
    	Pattern pattern = Pattern.compile(".*? (\\d+), (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	int first = Integer.parseInt(matcher.group(1));
        	int second = Integer.parseInt(matcher.group(2));
        	
        	double resFirstS = Math.pow(first,1./2.);
        	double resFirstC = Math.pow(first,1./3.);
        	
        	if ((resFirstS == Math.floor(resFirstS)) && (resFirstC == Math.floor(resFirstC)))
        		return String.valueOf(first);

        	double resSecS = Math.pow(second,1./2.);
        	double resSecC = Math.pow(second,1./3.);
        	
        	if ((resSecS == Math.floor(resSecS)) && (resSecC == Math.floor(resSecC)))
        		return String.valueOf(second);
        	
      		return "";

    	}
    	return String.valueOf(result);
	}


    public String processLargest(String query)
    {
    	String numbers = query.substring(query.lastIndexOf(":")+1);
    	
    	String[] numberSplit = numbers.split(",");
    	
    	int highest = Integer.MIN_VALUE;
    	
    	for(String num: numberSplit)
    	{
    		int number = Integer.valueOf(num.replace(" ", ""));
    		if (number > highest)
    			highest = number;
    	}
    	return String.valueOf(highest);
    }
}
