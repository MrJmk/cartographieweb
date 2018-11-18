package com.cartoweb.crawler;

import com.cartoweb.filesystem.Filesystem;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Scraper {

    public List<String> liens = new LinkedList<String>(); // liste des URLs
    public Document htmlDocument; //le html de la webpage
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";



    public void scrape(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();

            this.htmlDocument = Jsoup.parse(htmlDocument.toString());

            Elements liensDePage = htmlDocument.select("a[href]");

            for(Element lien : liensDePage)
            {
                if ((lien.absUrl("href").contains(Crawler.trimUrl(url))) && !lien.absUrl("href").endsWith("#") && !lien.absUrl("href").endsWith("pdf"))
                    this.liens.add(lien.absUrl("href"));
            }

            enregistrerDansFichier(url);
        }
        catch(IOException ioe)
        {
            System.out.println("Erreur dans la requete HTTP  " + ioe);
        }

    }

    public List<String> getLiens()
    {
        return this.liens;
    }

    

    private void enregistrerDansFichier(String url) throws IOException {

        String[] words = htmlDocument.text().split(" ");
        String titre = htmlDocument.title();

        Filesystem.enregistrerFichier(url.replaceAll("[\\W]|_","") , "*PAGE:" + url + "\n*TITRE:"+titre+"\n", true);

        for (String word: words)
        {
            if (word != null) {
                Filesystem.enregistrerFichier(url.replaceAll("[\\W]|_","") , word + "\n", true);
            }
        }
    }

}
