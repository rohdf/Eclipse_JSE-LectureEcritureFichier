package nsis.app;

import nsis.metier2.MonFichier;

public class MonfichierApp {
	public static void main(String[] args){
//		MonFichier fichier = new MonFichier("/home/rfrimat/ftp.txt");
//		
//		fichier.info();
		
		try {
			   
		    if (args.length < 1) {
		     System.exit(0);
		    }

		    // le premier paramètre de main est le chemin d’accès au fichier
		    MonFichier leFichier = new MonFichier(args[0]);
		    leFichier.info();
		    
		    leFichier.copie("/home/rfrimat/ftp2.txt");

		  } catch (IllegalArgumentException e) {
		    e.printStackTrace();
		  }
	}
}
