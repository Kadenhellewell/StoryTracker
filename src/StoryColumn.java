import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class StoryColumn extends VBox
{
    Rectangle addStoryButton;

    StoryColumn()
    {
        addStoryButton = new Rectangle();
        addStoryButton.setOnMouseClicked(e ->
        {
            //TODO this where the code goes for adding a new story to the column. It should also add a new story the list of stories.
        });
    }

}
