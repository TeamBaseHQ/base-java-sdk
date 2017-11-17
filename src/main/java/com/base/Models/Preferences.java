package com.base.Models;

public class Preferences extends BaseModel {

    /**
     * Preferences category
     */
    private String category;
    /**
     * Preferences name
     */
    private String name;
    /**
     * Preferences value
     */
    private String value;
    /**
     * Preferences user_id
     */
    private String user_id;

    /**
     * Get Preferences Category
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set Preferences Category
     *
     * @param category
     * @return
     */
    public Preferences setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get Preferences Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set Preferences Name
     *
     * @param name
     * @return
     */
    public Preferences setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get Preferences Value
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Set Preferences Value
     *
     * @param value
     * @return
     */
    public Preferences setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get Preferences User_id
     *
     * @return
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Set Preferences User_id
     *
     * @param user_id
     * @return
     */
    public Preferences setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }
}
