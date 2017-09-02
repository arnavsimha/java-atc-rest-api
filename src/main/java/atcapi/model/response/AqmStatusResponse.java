package atcapi.model.response;

public class AqmStatusResponse extends AqmResponse {

    private boolean isSystemBooted;
    private int queueSize;

    public AqmStatusResponse(boolean isSystemBooted, int queueSize){
        super("Status Response");
        this.isSystemBooted = isSystemBooted;
        this.queueSize = queueSize;
    }

    public boolean isSystemBooted() {
        return isSystemBooted;
    }

    public int getQueueSize() {
        return queueSize;
    }
}
