package com.example.vimukthi.onlinepiza;

public class MenuItems {
    private String Name,Image;

    public MenuItems() {
    }

    public MenuItems(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image =Image;
    }
}
