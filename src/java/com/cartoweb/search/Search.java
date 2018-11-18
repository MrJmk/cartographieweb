/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartoweb.search;

import com.cartoweb.filesystem.Filesystem;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jmk
 */
public class Search {
    
    private Map<Integer, String[]> resultats = new HashMap<>();
    private String[] liste = Filesystem.listeFichier();
    private String tempContenu;
    
    public void search(String recherche) throws IOException{
       
        String[] wRech = recherche.split(System.lineSeparator());
        int i = 0;
        String[] result = null;
        
        for(String s : liste){
            
            int taux=0;
            tempContenu = Filesystem.lireFichier(s);
            
            for(String st : wRech){
                if(tempContenu.contains(st)){
                    taux++;
                }
            }
            
            if((taux/wRech.length)>=0.6){
                result = infoPage(s);
                resultats.put(i, result);
                i++;
            }
        } 
    }
    
    private String[] infoPage(String nomFichier) throws IOException{
        
        String[] info = null;
        String temp;
        
        temp = Filesystem.lireFichierLigne(nomFichier, 1);
        info[0] = temp.substring(6);
        
        temp = Filesystem.lireFichierLigne(nomFichier, 2);
        info[1] = temp.substring(7);
        
        return info;
    }
   

}
