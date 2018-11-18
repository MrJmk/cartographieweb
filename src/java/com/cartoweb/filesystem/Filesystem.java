package com.cartoweb.filesystem;

import java.io.*;

public class Filesystem {

    private static final String destinationFichier = "/home/jmk/NetBeansProjects/CartographiWeb/files/"; //System.getProperty("user.dir")

    public static String lireFichier(String nomFichier) throws IOException, FileNotFoundException, FileNotFoundException {
        FileReader fr = new FileReader(destinationFichier + nomFichier);
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String ligne = br.readLine();

        while (ligne != null) {
            sb.append(ligne);
            sb.append(System.lineSeparator());
            ligne = br.readLine();
        }

        return sb.toString();
    }

    public static void enregistrer(File fichier, String contenu, boolean ajouter) throws IOException {
        FileWriter fw = new FileWriter(fichier.getAbsoluteFile(), ajouter);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(contenu);
        bw.close();
    }

    public static void enregistrerFichier(String nomFichier, String contenu, boolean ajouter) throws IOException {

        File file = creerFichier(nomFichier);
        enregistrer(file, contenu, ajouter);
    }

    public static void supprimerFichier(String nomFichier)
    {
        new File(destinationFichier + nomFichier).delete();
    }

    public static File creerFichier(String nomFichier) throws IOException {

        File fichier= new File(destinationFichier + nomFichier);

        if (!fichier.exists()) fichier.createNewFile();

        return fichier;
    }
}
