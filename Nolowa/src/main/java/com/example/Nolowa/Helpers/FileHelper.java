package com.example.Nolowa.Helpers;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

public class FileHelper {
    public static Boolean downloadFileFromURL(String dest, String urlString) throws IOException {
        URL url = new URL("http://djsajinkwan.com/wp-content/uploads/2015/06/%E1%84%8C%E1%85%B3%E1%86%BC%E1%84%86%E1%85%A7%E1%86%BC%E1%84%89%E1%85%A2%E1%86%B7%E1%84%91%E1%85%B3%E1%86%AF1.jpg");
        //URL url = new URL(urlString);
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
        int buff = 16384;
        try {
            RandomAccessFile file = new RandomAccessFile(fileFullPath, "r");

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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return SHA;
    }
}
