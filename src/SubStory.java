import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SubStory extends Story
{
    File subStory;
    Story parent;
    ArrayList<SubStory> saves = new ArrayList<>();
    SubStory(String name)
    {
        super(name);
        try
        {
            subStory = new File(name + ".txt");
            if (subStory.createNewFile())
            {
                System.out.println("File created: " + subStory.getName());
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

    public void save()
    {

    }
}
