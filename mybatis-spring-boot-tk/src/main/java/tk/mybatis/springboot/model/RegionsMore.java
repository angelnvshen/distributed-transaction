package tk.mybatis.springboot.model;

import java.util.ArrayList;

public class RegionsMore extends Regions {
    private Integer nLevel;

    private ArrayList<RegionsMore> children = new ArrayList<RegionsMore>();

    public Integer getnLevel() {
        return nLevel;
    }

    public void setnLevel(Integer nLevel) {
        this.nLevel = nLevel;
    }

    public ArrayList<RegionsMore> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<RegionsMore> children) {
        this.children = children;
    }

    public RegionsMore() {
    }

    public RegionsMore(Integer id, Integer pid, String name, String remark) {
        this.setRegionId(id);
        this.setpRegionId(pid);
        this.setLocalName(name);
    }

    public void add(RegionsMore node) {//递归添加节点  
        if (new Integer(0).equals(node.getpRegionId()))  {
            this.children.add(node);
        } else if (node.getpRegionId().equals(this.getRegionId())) {
            this.children.add(node);
        } else {
            for (RegionsMore tmp_node : children) {
                tmp_node.add(node);
            }
        }
    }
}