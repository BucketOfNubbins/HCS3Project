public interface Drawable {

    // Returns either left most or bottom most coordinate, depending if it is a vertical or horizontal level
    public int getBound();

    // How far the object extends in the appropriate direction for horizontal or vertical levels
    public int getLength();

    //Draws the object, might need to be renamed
    public void draw();
}
