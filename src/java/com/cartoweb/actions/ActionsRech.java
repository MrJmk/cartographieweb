/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartoweb.actions;

import com.cartoweb.search.Search;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jmk
 */
public class ActionsRech {
    
    private Map<Integer, String[]> resultats = new HashMap<>();
           
    public void rechercher(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String rech = request.getParameter("recherche");
        
        Search searcher = new Search();
        searcher.search(rech);
        resultats = searcher.getResult(); 
    }
    
    public Map<Integer, String[]> getResultats(){
        return this.resultats;
    }
        
}
