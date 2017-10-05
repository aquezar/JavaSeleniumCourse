package utils;

import java.net.URL;

public class GetPathToResorce {

    public static String getPath(String fileName){
        String path = GetPathToResorce.class.getClassLoader().getResource(fileName).getPath();
        return path;
    }

    public static URL getURL(String fileName){
        URL path = GetPathToResorce.class.getClassLoader().getResource(fileName);
        return path;
    }
}
