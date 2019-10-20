package bo;

import java.io.Serializable;

public class Calcul implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String calcul; 
	private Double resultat;
	
	public Calcul() {
		this.calcul=this.generateCalcul();
		this.resultat=(double) this.solveCalcul(this.calcul);
	}
	
	private String generateCalcul() {
		
		return "1 + 1";
	}
	
	private Double solveCalcul(String unsolveCalcul) {
		
		return 2.0;
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
