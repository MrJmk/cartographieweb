/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartoweb.actions;

import com.cartoweb.crawler.Crawler;
import static java.lang.reflect.Array.set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jmk
 */
public class Actions {
    
        private Set<String> liens = new HashSet<String>();
        private HashSet<Set<String>> listes = new HashSet<Set<String>>();
        private String root;

        public void cartographier(HttpServletRequest request, HttpServletResponse response){
           
            String rech = request.getParameter("recherche");
            
            Crawler crawler = new Crawler(rech, 4);
            
            crawler.crawl();
            
            this.root = crawler.getRoot();
            this.liens = crawler.getListeLiens();
            
            //doubleListe();
        }
        
        public void doubleListe(){
            for (String it : liens){
                Crawler crawler = new Crawler(it, 4);
                crawler.crawl();
                listes.add(crawler.getListeLiens());
            }
        }
        
        
        public HashSet<Set<String>> getListes(){
            return this.listes;
        }
         
        public Set<String> getLiens(){
            return this.liens;
        }
        
         public String getRoot(){
            return this.root;
        }
}
