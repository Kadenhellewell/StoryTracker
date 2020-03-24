import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Story
{
    String name;
    File subsDirectory; //call mkdir() in the constructor. This directory should only have subStories
    SubStory mainSub;
    ArrayList<SubStory> subStories = new ArrayList<>();
    String currentDir = "";


    Story(String name)
    {
        this.name = name;
        currentDir = System.getProperty("user.dir");
        Path newPath = Paths.get(currentDir, this.name);
        subsDirectory = newPath.toFile();
        if(!subsDirectory.exists())
        {
            if(subsDirectory.mkdir())
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
        // Go into the substory directory to add the new file there
        subStories.add(subStory);
        Path proposed = Paths.get(currentDir, subsDirectory.toString());
        if(proposed.toFile().isDirectory())
        {
            System.setProperty("user.dir", proposed.toString());
        }
        else
        {
            System.out.print("Unable to go into this story's substory directory\n");
        }


        // Go back out so that other stories can be accessed
        File fileCurrent = new File(System.getProperty("user.dir"));
        System.setProperty("user.dir", fileCurrent.getParent());
    }
}
