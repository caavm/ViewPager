package inkadroid.com.viewpager;

/**
 * Created by CAAVM on 20/05/2016.
 */
public class News {
    private String title;
    private String description;
    private String mdate;
    private String image;
    private String source;


    public News(){

    }

    public News(String title,String description,String mdate,String image,String source){
        this.title=title;
        this.description=description;
        this.mdate=mdate;
        this.image=image;
        this.source=source;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMdate() {
        return mdate;
    }

    public String getImage() {
        return image;
    }

    public String getSource() {
        return source;
    }
}
