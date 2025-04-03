package pojos;

public class POJO_ReqResExpBody {

    private POJO_ReqResData data;
    private POJO_ReqResSupport support;

    public POJO_ReqResData getData() {
        return data;
    }

    public void setData(POJO_ReqResData data) {
        this.data = data;
    }

    public POJO_ReqResSupport getSupport() {
        return support;
    }

    public void setSupport(POJO_ReqResSupport support) {
        this.support = support;
    }

    public POJO_ReqResExpBody(POJO_ReqResData data, POJO_ReqResSupport support) {
        this.data = data;
        this.support = support;
    }

    public POJO_ReqResExpBody() {
    }

    @Override
    public String toString() {
        return "POJO_ReqResExpBody{" +
                "data=" + data +
                ", support=" + support +
                '}';
    }
}
