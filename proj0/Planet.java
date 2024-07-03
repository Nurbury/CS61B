
/*
 *@title Planet
 *@author NorBury
 *@version 1.0
 *@create 2024/7/2 17:18
 *@description
 */


public class Planet {
     public double xxPos;
     public double yyPos;
     public double xxVel;
     public double yyVel;
     public double mass;
     public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet (Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    /**
     * This method is calculate the Force Exerted  between two planets;
     *
     * @param p
     * @return
     */
    public double calcForceExertedBy(Planet p) {
        return (6.67e-11 * mass * p.mass) / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return (calcForceExertedBy(p) * (p.xxPos - xxPos) ) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return (calcForceExertedBy(p) * (p.yyPos - yyPos) ) / calcDistance(p);
    }



    public double calcNetForceExertedByX(Planet[] ps) {
        double F = 0.0;
        for (Planet p : ps) {
            if (p.xxPos == xxPos && p.yyPos == yyPos) {
                F += 0;
            }else {
                F += calcForceExertedByX(p);
            }
        }

        return F;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double F = 0.0;
        for (Planet p : ps) {
            if (p.xxPos == xxPos && p.yyPos == yyPos) {
                F += 0;
            }else {
                F += calcForceExertedByY(p);
            }
        }
        return F;
    }

    public void update(double dt, double fX, double fY) {
        double accelerationX = fX / mass;
        double accelerationY = fY / mass;
        xxVel = xxVel + dt * accelerationX;
        yyVel = yyVel + dt * accelerationY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}
