package com.software;
//Created By ws 实体类，用于作为Home_Fragment类当中的RecycleView的实体
public class MusicButtons {
    private String name;
    private int buttonId;

    public MusicButtons(String name, int buttonId) {
        this.name = name;
        this.buttonId = buttonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }
}
