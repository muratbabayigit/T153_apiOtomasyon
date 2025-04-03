package pojos;

public class POJO_ReqResSupport {
/*
        "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }

 */
    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public POJO_ReqResSupport(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public POJO_ReqResSupport() {
    }

    @Override
    public String toString() {
        return "POJO_ReqResSupport{" +
                "url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
