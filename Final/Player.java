import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int time = 100;
    private int speed = 3;
    private int money = 0;
    public Player(){
        GreenfootImage image = getImage();
        image.scale(50,50);
        setImage(image);
    }

    public void act(){
        move();
        shoot();
        if(intersect()){
            Greenfoot.setWorld(new Death());
        }
    }

    public int getTime(){
        return time;
    }

    public int getSpeed(){
        return speed;
    }
    
    public int getMoney(){
        return money;
    }

    public void setTime(int time){
        this.time = time;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void addMoney(int amount){
        this.money += amount;
    }

    public void move(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY() - speed);
        }else if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY() + speed);
        }else if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - speed,getY());
        }else if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + speed,getY());
        }
        if(getX() <= 100){
            setLocation(getX() + speed,getY());
        }
    }

    public void shoot(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(time <= 0 && mouse != null){
            Bullet bullet = new Bullet();
            int x = mouse.getX();
            int y = mouse.getY();
            getWorld().addObject(bullet, this.getX(), this.getY());
            bullet.turnTowards(x, y);
            this.time = 100;
        }else{
            time --;
        }
    }

    public boolean intersect(){
        if(getOneIntersectingObject(Enemy.class) != null){
            return true;
        }else{
            return false;
        }
    }
}