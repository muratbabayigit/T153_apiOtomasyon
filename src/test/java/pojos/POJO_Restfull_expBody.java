package pojos;

public class POJO_Restfull_expBody {

/*
     {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }

 */

    private int bookingid;
    private POJO_Restfull_reqBody booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public POJO_Restfull_reqBody getBooking() {
        return booking;
    }

    public void setBooking(POJO_Restfull_reqBody booking) {
        this.booking = booking;
    }

    public POJO_Restfull_expBody(int bookingid, POJO_Restfull_reqBody booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public POJO_Restfull_expBody() {
    }

    @Override
    public String toString() {
        return "POJO_Restfull_expBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
