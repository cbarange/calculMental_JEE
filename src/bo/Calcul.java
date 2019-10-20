package bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calcul implements Serializable {
	
	private class CalculOperateur{
		
		public String randomOperationBinaire() {
			int random=(int) Math.floor((Math.random()+1)*3);
			switch(random) {
			case 1:
				return "-";
			case 2:
				return "/";
			case 3:
				return "*";
			default:
				return "+";
			}
		}
		
		public String randomOperationUnaire() {
			int random=(int) Math.floor((Math.random()+1)*2);
			switch(random) {
			case 1:
				return "inv";
			case 2:
				return "rac";
			default:
				return "inv";
			}
		}
		
		public String randomNumber() {
			if(Math.random()<0.5)
				return ((Double)(Math.floor(Math.random()*10000.0)/100.0)).toString();
			else
				return ((Double)Math.floor(Math.random()*100)).toString();
				
		}
	}
	
	private static final long serialVersionUID = 1L;
	private String calcul; 
	private Double resultat;
	
	public Calcul() {
		this.calcul=this.generateCalcul();
		this.resultat=(double) this.solveCalcul(this.calcul);
	}
	
	public boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	private String generateCalcul() {
		CalculOperateur ope=new CalculOperateur();
		String res="";
		res+=ope.randomNumber()+" ";
		if(Math.random()<0.5)
			res+=ope.randomNumber()+" "+ope.randomOperationBinaire()+" ";
		else
			res+=ope.randomOperationUnaire()+" ";
		res+=ope.randomNumber()+" "+ope.randomOperationBinaire();
		if(Math.random()<0.5)
			res+=" "+ope.randomOperationUnaire();
		return res+" ";
	}
	
	private Double solveCalcul(String unsolveCalcul) {
		char someChar = ' ';
		int count = 0;
		String patternString="";
		List<Double> list=new ArrayList<>();
		for (int i = 0; i < unsolveCalcul.length(); i++) {
		    if (unsolveCalcul.charAt(i) == someChar) {
		        count++;
		        patternString+="(.*)\\s"; 
		    }
		}
		
		Pattern pattern=Pattern.compile(patternString);
		Matcher matcher;
		matcher=(pattern.matcher(unsolveCalcul));
		matcher.matches();
		
		for(int i=0;i<count;i++) {
			//System.out.println(matcher.group(0)+ "-- 0 --");
			//System.out.println(matcher.group(i+1)+ "-- 1 --");
			//System.out.println(matcher.group(2)+ "-- 2 --");
			//System.out.println(matcher.group(3)+ "-- 3 --");
			
			if(isNumeric(matcher.group(i+1))) {
				double chiffre=Double.parseDouble(matcher.group(i+1));
				list.add(chiffre);
			}else {
				Double var1;
				Double var2;
				switch(matcher.group(i+1)) {
				case "+":
					var1=list.get(list.size()-1);
					var2=list.get(list.size()-2);
					list.remove(list.size()-1);
					list.remove(list.size()-1);
					list.add(var2+var1);
					break;
				case "-":
					var1=list.get(list.size()-1);
					var2=list.get(list.size()-2);
					list.remove(list.size()-1);
					list.remove(list.size()-1);
					list.add(var2-var1);
					break;
				case "*":
					var1=list.get(list.size()-1);
					var2=list.get(list.size()-2);
					list.remove(list.size()-1);
					list.remove(list.size()-1);
					list.add(var2*var1);
					break;
				case "/":
					var1=list.get(list.size()-1);
					var2=list.get(list.size()-2);
					list.remove(list.size()-1);
					list.remove(list.size()-1);
					list.add(var2/var1);
					break;
				case "inv":
					var1=list.get(list.size()-1);
					list.remove(list.size()-1);
					list.add(1/var1);
					break;
				case "rac":
					var1=list.get(list.size()-1);
					list.remove(list.size()-1);
					list.add(Math.sqrt(var1));
					break;
				}
			}
		}
		return Math.floor(list.get(list.size()-1)*10.0)/10.0;
		//return 2.0;
	}

	public Double getResultat() {
		return resultat;
	}

	public void setResultat(Double resultat) {
		this.resultat = resultat;
	}

	public String getCalcul() {
		return calcul;
	}

	public void setCalcul(String calcul) {
		this.calcul = calcul;
	}
}
