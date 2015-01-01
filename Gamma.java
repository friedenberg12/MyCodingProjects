import java.net.*;
import java.io.*;

public class Gamma {
	
	private URL[] sites;
	private BufferedReader read;

	public Gamma() {
		sites = new URL[6];
	}

	public void checkSites() {
		sites[0] = new URL("http://techcrunch.com/feed/");
		sites[1] = new URL("http://rss.cnn.com/rss/cnn_tech.rss");
		sites[2] = new URL("http://feeds.sciencedaily.com/sciencedaily/computers_math/computer_programming");
		sites[3] = new URL("http://www.i-programmer.info/index.php?option=com_ninjarsssyndicator&feed_id=1&format=raw");
		sites[4] = new URL("http://phys.org/rss-feed/breaking/science-news/mathematics/");
		sites[5] = new URL("http://topics.nytimes.com/top/news/science/topics/mathematics/index.html?rss=1");
	}

	public void setup() {
		System.out.println("Good Morning, David. I hope that you had a wonderful sleep.");
		System.out.print("Please press Enter to verify consciousness:");
		Scanner press_enter = new Scanner(System.in);
		if(press_enter.hasNext()) {
			System.out.println("Thank you. Please stand by while I setup this morning's news.");
		}
		press_enter.close();
		for(int i=0;i<sites.length;i++) {
			setupReader(sites[i]);
		}
		System.out.println("Thank you David, and have a good morning.");
	}

	private void setupReader(URL site) {
		BufferedReader web_in = new BufferedReader(new InputStreamReader(site.openStream()));
		readSite(web_in);
		web_in.close();
	}

	private void readSite(BufferedReader reader) {
		
	}
}
