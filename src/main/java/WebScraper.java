import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * @author bryanh2
 * Class made for Lab 3 of the CS125 Lab
 */
public class WebScraper {

    /**
     * @param args
     * Main method
     */
    public static void main(final String[] args) {
        // TODO Auto-generated method stub
        String countingWord = "thou";


        String url = urlToString("http://erdani.com/tdpl/hamlet.txt");

        int wordCount = 0;
        while (url.contains(countingWord)) {
            wordCount++;
            url = url.substring(url.indexOf(countingWord) + countingWord.length());
        }
        System.out.println(wordCount);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
