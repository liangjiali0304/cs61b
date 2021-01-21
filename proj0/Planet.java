import java.lang.Math;

public class Planet {
    /**
     * define the basic params
     */
    public double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;


    /**
     * first constructor
     */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * second constructor
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double r = Math.sqrt(dx * dx + dy * dy);
        return r;
    }

    /** calculate g force by one planet p*/
    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double r = this.calcDistance(p);
        double F = G * this.mass * p.mass / (r * r);
        return F;
    }

    /** calculate x-dir force by one planet p*/
    public double calcForceExertedByX(Planet p) {
        double F_net = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double Fx = F_net * dx / r;
        return Fx;
    }

    /** calculate y-dir force by one planet p*/
    public double calcForceExertedByY(Planet p) {
        double F_net = this.calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double Fy = F_net * dy / r;
        return Fy;

    }
    /** sum up all the x dir forces*/
    public double calcNetForceExertedByX(Planet[] planet_arr) {
        double sum_x = 0;
        for (Planet i: planet_arr) {
            if (i == this){continue;}
            sum_x += this.calcForceExertedByX(i);

        }
        return sum_x;
    }

    /** sum up all the y dir forces*/
    public double calcNetForceExertedByY(Planet[] planet_arr) {
        double sum_y = 0;
        for (Planet i: planet_arr) {
            if (i == this){continue;}
            sum_y += this.calcForceExertedByY(i);
        }
        return sum_y;
    }

    /** update the planet x,y pos and vel using a small force over dt period*/

    public void update(double dt, double Fx, double Fy){
        double ax = Fx / this.mass;
        double ay = Fy / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos, "images/"+imgFileName,2.5e10,2.5e10);
    }

}