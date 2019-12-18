import javax.xml.crypto.Data;

public class Product
{
    private Data data;

    private String success;

    private String type;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", success = "+success+", type = "+type+"]";
    }


    public Product(Data data, String success, String type) {
        this.data = data;
        this.success = success;
        this.type = type;
    }
}