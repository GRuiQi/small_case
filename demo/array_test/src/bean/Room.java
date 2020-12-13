package bean;

public class Room {

    //房间编号
    private String id;

    //房间类型
    private String type;

    //房间状态 是否被占用
    private boolean isUse;

    public Room() {
    }

    public Room(String id, String type, boolean isUse) {
        this.id = id;
        this.type = type;
        this.isUse = isUse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    @Override
    public String toString() {
        return "{" +
                id +","+ type + ","+(isUse?"占用":"空闲") +
                '}';
    }
}
