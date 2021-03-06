package tk.mybatis.springboot.model;

import javax.persistence.*;

@Table(name = "t_lock_history")
public class TLockHistory {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "OLD_ID")
    private Integer oldId;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return VALUE
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return VERSION
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return OLD_ID
     */
    public Integer getOldId() {
        return oldId;
    }

    /**
     * @param oldId
     */
    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }
}