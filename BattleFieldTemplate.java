import javax.swing.*;
import java.awt.*;

public class BattleFieldTemplate extends JPanel
{
    int tankX = 64;
    int tankY = 64*2;
    int stepT = 2;
    boolean COLORDED_MODE=true;


    /**
     * Write your code here.
     */
    void runTheGame()
    {   int i=20;
        int delta=1;
        System.out.println("Started");

        while (true) {
            while (delta > 0 & (tankX < 64 * 9)) {
                repaint();
                tankX += i;
                sleep(100);
            }

            delta = -1;
            while (delta < 0 & (tankX > 0)) {
                repaint();
                tankX -= i;
                sleep(100);
            }
            delta = 1;
            continue;
        }
//



    }

    /**
     * Should move the tank one quadrant right.
     *
     * Every quadrant has width of 64px;
     *
     * Use:
     *
     * repaint() to repaint the screen
     * sleep(millis) to sleep millis amount of milliseconds
     */
/* 1- UP
   2- Down
   3- Left
   4- Right
 */
    void moveAnz(int s) {
        sleep(300);
        if (s == 1) {

            if (tankX <= 64 * 8 & tankX >= 0 & (tankY - 64) <= 64 * 8 & (tankY - 64) >= 0) {
                System.out.println("UP");
                tankY-=64;

            }
        } else if (s == 2) {

            if (tankX <= 64 * 8 & tankX >= 0 & (tankY + 64) <= 64 * 8 & (tankY + 64) >= 0) {
                System.out.println("down");
                tankY+=64;
            }
        }
         else if (s == 3) {
            //System.out.println("start3"+" "+tankX+" " + tankY);
            if ((tankX-64) <= 64 * 8 & (tankX-64) >= 0 & (tankY) <= 64 * 8 & (tankY) >= 0) {
               System.out.println("left");
               tankX-=64;
            }
        }
        else if (s == 4) {
            if ((tankX + 64) <= 64 * 8 & (tankX + 64) >= 0 & (tankY) <= 64 * 8 & (tankY) >= 0) {
                System.out.println("right");
                tankX+=64;
            }
        }
        else {
           // System.out.println("Incorrect input");
        }
        repaint();
    }

    void moveForward()
    {

    }




    void moveRandom() {
        String randomN;
        int randomI;
        randomN = String.valueOf(System.currentTimeMillis());
        randomN = randomN.substring(12, 13);
        randomI = Integer.parseInt(randomN);
        //System.out.println(System.currentTimeMillis());

        while (true) {
            randomN = String.valueOf(System.currentTimeMillis());
            randomN = randomN.substring(12, 13);
            randomI = Integer.parseInt(randomN);
            if (randomI > 4) {
                randomI = randomI - 4;
            }
            moveAnz(randomI);

            System.out.println(randomN);
        }
    }


        String getQuadrant(String v, String h)
        {
            String rez;
            int hh;
            int vv;

            if(v.equals("a")) {
                vv = 1;
            }
            else if (v.equals("b"))
            {vv=2;}
            else if (v.equals("c"))
            {vv=3;}
            else if (v.equals("d"))
            {vv=4;}
            else if (v.equals("e"))
            {vv=5;}
            else if (v.equals("f"))
            {vv=6;}
            else if (v.equals("g"))
            {vv=7;}
            else if (v.equals("h"))
            {vv=8;}
            else
            {vv=9;}

            hh=(Integer.parseInt(h)-1)*64;
            return(hh+"_"+((vv-1)*64));
        }

    void moveToQuadrant(String v, String h)
    {
        String CoordinatX;
        String CoordinatY;
        String CoordXY;
        int CoordXint;
        int CoordYint;

        // get coordinates
        CoordXY=getQuadrant(v,h);
        CoordinatX=CoordXY.substring(0,CoordXY.indexOf("_"));
        CoordinatY=CoordXY.substring(CoordXY.indexOf("_")+1);
        System.out.println(CoordinatX);
        System.out.println(CoordinatY);

        //move the tank
        CoordYint=Integer.valueOf(CoordinatY);
        CoordXint=Integer.valueOf(CoordinatX);

        while (tankY < CoordYint){
            moveAnz(2);//down
            }
        while (tankY > CoordYint) {
            moveAnz(1); //up
        }
        while (tankX < CoordXint){
            moveAnz(4);//right
        }
        while (tankX > CoordXint) {
            moveAnz(3);//left
        }
    }

    // Magic bellow. Do not worry about this now, you will understand everything in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;
    
    //-------------MAIN--------------------------------------------------------------------------------
    //-------------MAIN--------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception
    { int m = 4;
        BattleFieldTemplate bf = new BattleFieldTemplate();
       // bf.runTheGame();
       // bf.moveAnz(m);
      //  bf.moveRandom();
        System.out.println("x:"+bf.tankX+" y:"+ bf.tankY);
        bf.moveToQuadrant("a","2");
        bf.moveToQuadrant("i","8");

        //System.out.println(bf.getQuadrant ("a","4"));
    }

    public BattleFieldTemplate() throws Exception
    {
        JFrame frame = new JFrame("MOVE TANK FORWARD");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH + 22, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {

        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        paintBF(g);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

    private void paintBF(Graphics g)
    {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++)
        {
            for (int h = 0; h < 9; h++)
            {
                if (i % 2 == 0)
                {
                    cc = new Color(252, 241, 177);
                }
                else
                {
                    cc = new Color(233, 243, 255);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }
    }

}
