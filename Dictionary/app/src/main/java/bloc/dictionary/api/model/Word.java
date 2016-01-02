package bloc.dictionary.api.model;

/**
 * Created by Austin on 12/19/2015.
 */
public class Word {

    private String title;
    private String partOfSpeech;
    private String forms;
    private String definition;

    public Word(String title, String partOfSpeech, String forms, String definition){
        this.title = title;
        this.partOfSpeech = partOfSpeech;
        this.forms = forms;
        this.definition = definition;
    }

    private String getForms(){
        return forms;
    }

    private String setForms(String forms){
        this.forms = forms;
    }

    public String getPartOfSpeech(){
        return partOfSpeech;
    }

    public String setPartOfSpeech(String partOfSpeech){
        this.partOfSpeech = partOfSpeech;
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
