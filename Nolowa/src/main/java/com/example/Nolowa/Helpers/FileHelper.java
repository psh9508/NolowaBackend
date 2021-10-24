package com.example.Nolowa.Helpers;

import com.example.Nolowa.Constant;
import org.apache.el.parser.BooleanNode;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class FileHelper {
    public static Boolean downloadFileFromURL(String dest, String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(dest);
        fos.write(response);
        fos.close();

        return true;
    }

    public static String extractFileHashSHA256(String fileFullPath) throws Exception {
        String SHA = "";
        String targetPath = fileFullPath;

        int buff = 16384;
        try {
            if(isExists(fileFullPath) == false) {
                String tempDownloadPath = Constant.profileImageRootPath + "temp.jpg";

                downloadFileFromURL(tempDownloadPath, fileFullPath);

                targetPath = tempDownloadPath;
            }

            RandomAccessFile file = new RandomAccessFile(targetPath, "r");

            MessageDigest hashSum = MessageDigest.getInstance("SHA-256");

            byte[] buffer = new byte[buff];
            byte[] partialHash = null;

            long read = 0;

            // calculate the hash of the hole file for the test
            long offset = file.length();
            int unitsize;
            while (read < offset) {
                unitsize = (int) (((offset - read) >= buff) ? buff : (offset - read));
                file.read(buffer, 0, unitsize);

                hashSum.update(buffer, 0, unitsize);

                read += unitsize;
            }

            file.close();
            partialHash = new byte[hashSum.getDigestLength()];
            partialHash = hashSum.digest();

            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < partialHash.length ; i++){
                sb.append(Integer.toString((partialHash[i]&0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();

            if(targetPath.contains(SHA) == false) {
                rename(targetPath, Constant.profileImageRootPath + SHA + ".jpg");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return SHA;
    }

    public static Boolean isExists(String filePath) {
        var file = new File(filePath);

        return file.exists();
    }

    public static Boolean rename(String dest, String source) {
        var file = new File(dest);

        if(file.exists() == false)
            return false;

        return file.renameTo(new File(source));
    }
}
