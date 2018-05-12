package com.xz.web.entity;

import com.xz.framework.common.base.BasicBean;

public class TiQianLib extends BasicBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.id
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.pic
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private String pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.name
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.publish_time
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private String publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.create_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private String createTimestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ti_qian_lib.update_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    private String updateTimestamp;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_qian_lib
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public TiQianLib(Long id, String pic, String name, String publishTime, String createTimestamp, String updateTimestamp) {
        this.id = id;
        this.pic = pic;
        this.name = name;
        this.publishTime = publishTime;
        this.createTimestamp = createTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ti_qian_lib
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public TiQianLib() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.id
     *
     * @return the value of ti_qian_lib.id
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.id
     *
     * @param id the value for ti_qian_lib.id
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.pic
     *
     * @return the value of ti_qian_lib.pic
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.pic
     *
     * @param pic the value for ti_qian_lib.pic
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.name
     *
     * @return the value of ti_qian_lib.name
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.name
     *
     * @param name the value for ti_qian_lib.name
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.publish_time
     *
     * @return the value of ti_qian_lib.publish_time
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.publish_time
     *
     * @param publishTime the value for ti_qian_lib.publish_time
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime == null ? null : publishTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.create_timestamp
     *
     * @return the value of ti_qian_lib.create_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String getCreateTimestamp() {
        return createTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.create_timestamp
     *
     * @param createTimestamp the value for ti_qian_lib.create_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp == null ? null : createTimestamp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ti_qian_lib.update_timestamp
     *
     * @return the value of ti_qian_lib.update_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ti_qian_lib.update_timestamp
     *
     * @param updateTimestamp the value for ti_qian_lib.update_timestamp
     *
     * @mbggenerated Sat May 12 18:17:19 CST 2018
     */
    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp == null ? null : updateTimestamp.trim();
    }
}