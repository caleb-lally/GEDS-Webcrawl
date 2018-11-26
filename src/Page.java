import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("links")
    @Expose
    public List<String> links = null;

    public Page withAddress(String address) {
        this.address = address;
        return this;
    }

    public Page withLinks(List<String> links) {
        this.links = links;
        return this;
    }

}