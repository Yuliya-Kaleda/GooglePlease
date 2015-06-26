package nyc.c4q.yuliyakaleda.pleasegoogle;

/**
 * Created by July on 6/25/15.
 */
public class JobPosition {
    public String title;
    public String company;
    public String link;

    public JobPosition(String title, String link) {
        this.title = title;
        this.company = company;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLink() {
        return link;
    }
}
