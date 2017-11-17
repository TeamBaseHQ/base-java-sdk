package com.base.Models;

public class Preference extends BaseModel {

    /**
     * Preference category
     */
    private String category;
    /**
     * Preference name
     */
    private String name;
    /**
     * Preference value
     */
    private String value;
    /**
     * Preference user_id
     */
    private String user_id;

    /**
     * Get Preference Category
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set Preference Category
     *
     * @param category
     * @return
     */
    public Preference setCategory(String category) {
        this.category = category;
        return this;
    }

    /**
     * Get Preference Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set Preference Name
     *
     * @param name
     * @return
     */
    public Preference setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get Preference Value
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * Set Preference Value
     *
     * @param value
     * @return
     */
    public Preference setValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get Preference User_id
     *
     * @return
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Set Preference User_id
     *
     * @param user_id
     * @return
     */
    public Preference setUser_id(String user_id) {
        this.user_id = user_id;
        return this;
    }
}
