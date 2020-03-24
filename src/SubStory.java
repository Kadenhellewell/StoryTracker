import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SubStory
{
    Story parent;
    String name;
    String currentDir;
    ArrayList<Save> saves = new ArrayList<>();
    Save newestSave;
    File savesDirectory;
    SubStory(Story parent, String name)
    {
        this.parent = parent;
        this.name = name;

        currentDir = System.getProperty("user.dir");
        Path newPath = Paths.get(currentDir, Paths.get(parent.subsDirectory.toString(), name).toString());//creates new path that goes from currentDir to dirName
        savesDirectory = newPath.toFile();
        if(!savesDirectory.exists())
        {
            if(savesDirectory.mkdir())
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
        save(parent.mainSub.newestSave.getText());
    }

    public void save(String storySave)
    {
        Save newSave = new Save();
        //Write the new save to a file write here
        saves.add(0, newSave);
        newestSave = newSave;
    }
}
