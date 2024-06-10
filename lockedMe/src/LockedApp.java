import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

public class LockedApp {

    private ArrayList<File> fileList;
    private ArrayList<String> fileNames;
    public LockedApp() {

        fileList = new ArrayList<File>();
        fileNames = new ArrayList<String>();
    }

    public void addFile(String name) {

        try {

            boolean fileExists = false;

            for(String fname: this.fileNames) {
                if(fname.toLowerCase().equals(name.toLowerCase())) {
                    fileExists = true;
                    break;
                }
            }

            if (fileExists) {
                System.out.println("File already exists.");
                return;
            }
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("File created: " + name);
                this.fileList.add(file);
                this.fileNames.add(name);
            } 
            else {
                System.out.println("File already exists in directory but not in list.");
                    this.fileList.add(file);
                    this.fileNames.add(name);
                    System.out.println("File added to the list.");
            }
        } catch (IOException e) {
            System.out.println("Error while adding the file: " + e);
        
        }
    }

    public void deleteFile(String name) {
        File file = new File(name);
        if (file.exists()) {
            if (file.delete()) {
                this.fileList.removeIf(f -> f.getPath().equals(name));
                this.fileNames.remove(name);
                System.out.println("File deleted successfully.");
            } 
            else {
                System.out.println("Error while deleting file");
            }
        } 
        else {
            System.out.println("File not found.");
        }
    }

    public void printSortedFiles() {
        if (this.fileNames.isEmpty()) {
            System.out.println("No files found.");
            return;
        }
        Collections.sort(this.fileNames);
        System.out.print("Sorted files: ");
        for (String fileName : this.fileNames) {
            System.out.print(fileName + ", ");
        }
        System.out.println();
    }

    // binary search to find filename
    public void searchFile(String fileName) {
        Collections.sort(this.fileNames);
        boolean found = false;
        int low = 0;
        int high = this.fileNames.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (this.fileNames.get(mid).equals(fileName)) {
                System.out.println("File found: " + fileName);
                found = true;
                break;
            } 
            else if (this.fileNames.get(mid).compareTo(fileName) < 0) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("File not found.");
        }
    }
    
}
