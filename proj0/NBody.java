
/*
 *@title NBody
 *@author NorBury
 *@version 1.0
 *@create 2024/7/2 21:40
 *@description
 */

public class NBody {



    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int planetNum = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[planetNum];
        for (int i = 0; i < planetNum; i++) {
            planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return planets;
    }

    /**
     * read the radius, which represent the radius of universe, according to the filePath;
     * @param filePath
     * @return
     */
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        int num = in.readInt();
        return in.readDouble();
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double time = 0;

        Planet[] planets = readPlanets(fileName);
        double radius = readRadius(fileName);

        while (time < T) {
            double[] xFroce = new double[5];
            double[] yForce = new double[5];
            for (int i = 0; i < planets.length; i++) {
                xFroce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt,xFroce[i],yForce[i]);
            }
            StdDraw.setScale(-radius,radius);
//        StdDraw.setPenRadius(radius);
            StdDraw.clear();
            StdDraw.picture(0,0,"images/starfield.jpg");

            for (Planet p : planets) {
                StdDraw.picture(p.xxPos, p.yyPos, "images/" + p.imgFileName);
            }


            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }








    }
}
