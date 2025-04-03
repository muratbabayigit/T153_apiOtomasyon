package pojos;

public class POJO_JPH {

   /*
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
     */
    //1-Tüm variable'lar private olarak oluşturulur
    private String title;
    private String body;
    private int userId;
    private int id;

    //2-Tüm variable'lar için getter and setter metodları oluşturulur


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //3-Tüm parametreleri içeren bir parametreli constructor oluşturuyoruz

    public POJO_JPH(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    //4-Parametresiz bir constructor oluşturalım

    public POJO_JPH() {
    }

    //5-toString methodu oluşturulur


    @Override
    public String toString() {
        return "POJO_JPH:\n" +
                "title=" + title + "\n" +
                "body=" + body + "\n" +
                "userId=" + userId +"\n" +
                "id=" + id ;
    }
}
