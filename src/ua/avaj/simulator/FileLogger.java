package ua.avaj.simulator;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private static final String FILENAME = "simulation.txt";
    private static FileWriter fw;
    private static BufferedWriter bw;
    private static FileLogger logger;

    public FileLogger() {
        try {
            fw = new FileWriter(FILENAME);//, true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            System.out.println("Error while creating file: " + FILENAME);
            System.exit(1);
//            e.printStackTrace();
        }
    }

    public static FileLogger getLogger() {
        if (logger == null) {
            logger = new FileLogger();
        }
        return logger;
    }

    public void log(String text) {
        try {
            bw.write(text);
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + FILENAME);
            System.exit(1);
        }

    }

    public void logln(String text) {
        try {
            bw.write(text);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + FILENAME);
            System.exit(1);
        }

    }

    public void killLogger() {
        try {
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            System.out.println("Error while finishing logging!");
            System.exit(1);
//            ex.printStackTrace();
        }
    }

}
