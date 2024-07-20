package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("C:\\Users\\user\\IdeaProjects\\Games"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\src"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\res"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\savegames"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\temp"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\src\\main"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\src\\test"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\res\\drawables"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\res\\vectors"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\res\\icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C:\\Users\\user\\IdeaProjects\\Games\\src\\main\\Main.java"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\src\\main\\Utils.java"),
                new File("C:\\Users\\user\\IdeaProjects\\Games\\temp\\temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) {
                stringBuilder.append("New folder ").append(folder).append(" created");
            } else {
                stringBuilder.append("Folder ").append(folder).append(" not found or already exist");
            }
        });

        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) {
                    stringBuilder.append("File ").append(file).append(" created");
                } else {
                    stringBuilder.append("File ").append(file).append(" not found or already exist");
                }

            } catch (IOException e) {
                stringBuilder.append(e.getMessage()).append('\n');
            }
        });

        try (FileWriter log = new FileWriter("C:\\Users\\user\\IdeaProjects\\Games\\temp\\temp.txt", false)) {
            log.write(stringBuilder.toString());
            log.flush();
        } catch (IOException e) {
            stringBuilder.append(e.getMessage()).append('\n');
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\Games\\temp\\temp.txt"))) {
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}