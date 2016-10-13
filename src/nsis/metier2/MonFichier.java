package nsis.metier2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MonFichier extends File {
 
 private static final long serialVersionUID = 1L;

 public MonFichier(String nomFichier)

 throws IllegalArgumentException {
  super(nomFichier);
  if (!exists()){
   // si le fichier n’existe pas sur le système
	  System.out.println("No j'existe po!!");
   throw new IllegalArgumentException("Fichier inexistant");
  }
  if (isDirectory()){
   // si c’est un répertoire
	  System.out.println("Oui j'existe !!");  
   throw new IllegalArgumentException("C'est un répertoire");
  }
 }
 
 public void info() {

	 System.out.println("Fichier..............." + getName());

	 System.out.println(" Accès en lecture " + canRead());

	 System.out.println(" Accès en écriture " + canWrite());

	 System.out.println(" Taille " + length());

	 }
 
 public void copie(String destination) {
	  try {
	   File ficDest = new File(destination);
	   long taille = length();
	   if (taille > Integer.MAX_VALUE) {
	    taille = Integer.MAX_VALUE;
	    System.out.println("attention : copie des " + Integer.MAX_VALUE
	      + " premiers octets !");
	   }
	   byte[] buffer = new byte[(int) taille];
	   FileInputStream fluxLecture;
	   fluxLecture = new FileInputStream(this);
	   fluxLecture.read(buffer);
	   fluxLecture.close();

	   // écriture du contenu du fichier source dans le flux standard de
	   // sortie

	   System.out.println(new String(buffer));

	   // écriture du contenu du fichier source dans le fichier destination

	   FileOutputStream fluxEcriture;
	   fluxEcriture = new FileOutputStream(ficDest);
	   fluxEcriture.write(buffer);
	   fluxEcriture.close();

	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }
}
