package eris.om.discoracle.model;

import java.io.Serializable;

/**
 * Created by Gorka on 04/04/2016.
 */
public class Luna  implements Serializable{
    private double age;
    private double illumination;
    private String stage;
    private double DFCOE;
    private double DFS;

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getIllumination() {
        return illumination;
    }

    public void setIllumination(double illumination) {
        this.illumination = illumination;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public double getDFCOE() {
        return DFCOE;
    }

    public void setDFCOE(double DFCOE) {
        this.DFCOE = DFCOE;
    }

    public double getDFS() {
        return DFS;
    }

    public void setDFS(double DFS) {
        this.DFS = DFS;
    }
}
