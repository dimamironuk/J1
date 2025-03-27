import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {
    public static void downloadImage(String imageUrl, String savePath) throws Exception {
        try (InputStream in = new URL(imageUrl).openStream();
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
