package dnt.com.androidbestpractices.filter;

/**
 * Created by sir.dnt@gmail.com on 2019-04-24.
 */
//TODO step 1 create entity
public class Contact {

    private String name;
    private String image;
    private String phone;

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
