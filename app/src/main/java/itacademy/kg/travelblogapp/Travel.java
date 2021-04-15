package itacademy.kg.travelblogapp;

public class Travel {
    String title;
    String tags;
    String descriptions;
    int image;
    String link;

    public Travel(String title, String tags, String descriptions, int image, String link) {
        this.title = title;
        this.tags = tags;
        this.descriptions = descriptions;
        this.image = image;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public int getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
}
