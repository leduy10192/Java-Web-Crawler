package jsoup.crawler;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupCrawler {
	public static void main (String[] args) throws IOException {
		//Create a doc to get the result from a url
		Document doc = Jsoup.connect("http://google.com").get();
		
		//Get some basic data from the title of the URL
		String title = doc.title();
		//Print title in console
		System.out.println("title :" + title);
		
		//Crawl all the hyperlinks
		Elements links = doc.select("a[href]");
		for(Element link: links) {
			System.out.println("\nlink :"+ link.attr("href"));
			System.out.println("text :"+ link.text());
		}
		
		//Extract all images from the website
		System.out.println("Getting all images...");
		Elements imags = doc.getElementsByTag("img");
		
		for(Element src: imags) {
			System.out.println("src :"+src.attr("abs:src"));
		}
		
	}
}
