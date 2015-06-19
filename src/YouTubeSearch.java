import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

class YouTubeSearch
{
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    private static final long NUMBER_OF_VIDEOS_RETURNED = 1;
    private static String Artist;
    private static String Title;
    private static String queryTerm;
    private static String[] youTubeLink;
    private static YouTube youtube;

    static String[] setter(String ARTIST, String TITLE) throws IOException, InterruptedException
    {
        Artist = ARTIST;
        Title = TITLE;
        queryTerm = Artist.concat(" - ").concat(Title);
        SearchResult[] retrievedVideo = new SearchResult[6];

        retrievedVideo[0] = YouTubeSearch("viewcount");
        retrievedVideo[1] = YouTubeSearch("relevance");
        queryTerm = Artist.concat(" ").concat(Title);
        queryTerm = queryTerm.concat(" Audio");
        retrievedVideo[2] = YouTubeSearch("relevance");
        queryTerm = Artist.concat(" ").concat(Title);
        queryTerm = queryTerm.concat(" Unplugged");
        retrievedVideo[3] = YouTubeSearch("relevance");
        queryTerm = Artist.concat(" ").concat(Title);
        queryTerm = queryTerm.concat(" Cover");
        retrievedVideo[4] = YouTubeSearch("relevance");
        queryTerm = Artist.concat(" ").concat(Title);
        queryTerm = queryTerm.concat(" Acoustic");
        retrievedVideo[5] = YouTubeSearch("relevance");

        String youTubeTitle[] = new String[6];
        youTubeLink = new String[6];

        for (int i = 0; i < 6; i++)
        {
            ResourceId rId = retrievedVideo[i].getId();
            if(checkResourceKind(rId))
            {
                youTubeTitle[i] = retrievedVideo[i].getSnippet().getTitle();
                youTubeLink[i] = rId.getVideoId();
            }
            else
                youTubeTitle[i] = "Oops";
        }

        for (int i = 0; i < 6; i++)
        {
            if(!checkTitle(youTubeTitle[i],Title))
            {
                youTubeTitle[i] = "Oops";
            }
        }
        return youTubeTitle;
    }

    private static SearchResult YouTubeSearch(String Order) throws IOException
    {
        Properties properties = new Properties();
        InputStream in = YouTubeSearch.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
        properties.load(in);
        YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer()
        {
            public void initialize(HttpRequest request) throws IOException
            {
            }
        }).setApplicationName("themp3catcher").build();

        YouTube.Search.List search = youtube.search().list("id,snippet");
        String apiKey = properties.getProperty("youtube.apikey");
        search.setKey(apiKey);
        search.setQ(queryTerm);
        search.setType("video");
        search.setFields("items(id/kind,id/videoId,snippet/title)");
        search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
        search.setOrder(Order);

        SearchListResponse searchResponse = search.execute();
        List<SearchResult> searchResultList = searchResponse.getItems();
        Iterator<SearchResult> iteratorSearchResults=searchResultList.iterator();
        return iteratorSearchResults.next();
    }

    private static boolean checkTitle(String youTubeTitle, String title)
    {
        System.out.println("Given Title = "+title+"\tYouTube Title = "+youTubeTitle);
        if(youTubeTitle.contains("&"))
        {
            youTubeTitle=youTubeTitle.replace("&","and");
        }
        return (formatString(youTubeTitle)).contains(formatString(title));
    }

    private static String formatString(String x)
    {
        return x.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }


    private static boolean checkResourceKind(ResourceId rId)
    {
        return rId.getKind().equals("youtube#video");
    }

    public static String[] getYouTubeLinks()
    {
        return youTubeLink;
    }
}