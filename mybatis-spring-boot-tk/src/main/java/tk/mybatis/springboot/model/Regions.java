package tk.mybatis.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "es_regions")
public class Regions implements Serializable {
    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regionId;

    @Column(name = "p_region_id")
    private Integer pRegionId;

    @Column(name = "region_path")
    private String regionPath;

    @Column(name = "region_grade")
    private Integer regionGrade;

    @Column(name = "local_name")
    private String localName;

    private String zipcode;

    private String cod;

    private static final long serialVersionUID = 1L;

    /**
     * @return region_id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * @return p_region_id
     */
    public Integer getpRegionId() {
        return pRegionId;
    }

    /**
     * @param pRegionId
     */
    public void setpRegionId(Integer pRegionId) {
        this.pRegionId = pRegionId;
    }

    /**
     * @return region_path
     */
    public String getRegionPath() {
        return regionPath;
    }

    /**
     * @param regionPath
     */
    public void setRegionPath(String regionPath) {
        this.regionPath = regionPath;
    }

    /**
     * @return region_grade
     */
    public Integer getRegionGrade() {
        return regionGrade;
    }

    /**
     * @param regionGrade
     */
    public void setRegionGrade(Integer regionGrade) {
        this.regionGrade = regionGrade;
    }

    /**
     * @return local_name
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * @param localName
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * @return zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regionId=").append(regionId);
        sb.append(", pRegionId=").append(pRegionId);
        sb.append(", regionPath=").append(regionPath);
        sb.append(", regionGrade=").append(regionGrade);
        sb.append(", localName=").append(localName);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", cod=").append(cod);
        sb.append("]");
        return sb.toString();
    }
}