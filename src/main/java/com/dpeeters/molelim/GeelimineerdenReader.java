package com.dpeeters.molelim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeelimineerdenReader {

    public static List<String> getGeelimineerden() throws IOException {

        File file = new File("C:\\Users\\danil\\Desktop\\demol-eliminatie\\geelimineerden.txt");
        Scanner sc = new Scanner(file);

        List<String> geelimineerden = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("#") || line.length() < 1) continue;
            geelimineerden.add(line);
        }
        sc.close();

        return geelimineerden;
    }

}
