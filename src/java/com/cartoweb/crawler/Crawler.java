package com.cartoweb.crawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler {

    private int MAX_PAGES_POUR_RECH = 10;
    private Set<String> pagesVisite = new HashSet<String>();
    private List<String> pagesAvisiter = new LinkedList<String>();
    private String rootUrl;



    public Crawler(String rootUrl, int nombreDePages) {
        this.rootUrl = rootUrl;
        this.MAX_PAGES_POUR_RECH = nombreDePages;
    }
    
    public String getRoot(){
        
        return this.rootUrl;
    }
    
    public Set<String> getListeLiens(){
        
        Set<String> liensPages = new HashSet<String>(pagesAvisiter);
        //List<String> pagesAvisiter = new LinkedList<String>(liensPages);
        
        return liensPages;
    }

    /**
     * Analyse du site Web en suivant des liens internes lors du scraping du HTML.
     *
     */
    public void crawl() {

        pagesAvisiter.add(rootUrl);

        String currentUrl;

        while( pagesAvisiter.size() < MAX_PAGES_POUR_RECH && ! pagesAvisiter.isEmpty() )
        {
            currentUrl = nextUrl();
            if(currentUrl == null) break; // if current url is null there is no more urls to scrape

            Scraper scraper = new Scraper();
            scraper.scrape(currentUrl);

            pagesAvisiter.addAll(scraper.getLiens());
            pagesVisite.add(trimUrl(currentUrl));
        }
    }


    
    private String nextUrl()
    {
        String nextUrl;

        do{
            nextUrl = pagesAvisiter.remove(0);
        }
        while( ! urlIsValid(nextUrl) && ! pagesAvisiter.isEmpty() );

        return pagesAvisiter.contains(nextUrl) ? null : nextUrl;
    }

    /**
     * Checks if a url is valid to be scraped:
     * It checks if we have already scraped the url and that the url is part of the original domain.
     *
     * @param nextUrl
     * @return
     */
    private boolean urlIsValid(String nextUrl) {

        String domain = trimUrl(rootUrl);
        nextUrl = trimUrl(nextUrl);

        return ( ! pagesVisite.contains(nextUrl) )  && nextUrl.contains(domain);
    }

    /**
     * remove http and www prefix and trailing slashes from url
     *
     * @param url
     * @return
     */
    public static String trimUrl(String url)
    {
        url = url.replaceFirst("^(http://www\\.|http://|www\\.|https://www\\.|https://)", "");

        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1); // remove last char
        }

        return url;
    }

}
