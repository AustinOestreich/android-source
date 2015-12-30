package bloc.dictionary.api.model;

/**
 * Created by Austin on 12/19/2015.
 */
public class Word {

    private String title;
    private String definition;

    public Word(String title, String definition){
        this.title = title;
        this.definition = definition;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDefinition(String definition){
        this.definition = definition;
    }

    public String getDefinition(){
        return definition;
    }
}
