

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pages extends Page {

    @SerializedName("pages")
    @Expose
    public List<Page> pages = null;

    public Pages withPages(List<Page> pages) {
        this.pages = pages;
        return this;
    }

}