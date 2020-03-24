import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Story
{
    String Name;
    File directory; //call mkdir() in the constructor. This directory should only have subStories
    ArrayList<SubStory> subStories = new ArrayList<>();

    Story(String name)
    {
        String currentDir = System.getProperty("user.dir");
        Path newPath = Paths.get(currentDir, name);
        directory = newPath.toFile();
        if(!directory.exists())
        {
            if(directory.mkdir())
            {
                System.out.print("The story directory was successfully created.\n");
            }
            else
            {
                System.out.print("The story directory was not successfully created.\n");
            }
        }
        else
        {
            System.out.print("A file or directory by that name already exists.\n");
        }
    }

    public void addSub(SubStory subStory)
    {
        subStories.add(subStory);
        try
        {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile())
            {
                System.out.println("File created: " + myObj.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
