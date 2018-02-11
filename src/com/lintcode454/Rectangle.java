package com.lintcode454;

/**454. 矩阵面积
 * 挑战：
 * @author sumuxi
 *
 */
public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    public int width;
    public int height;

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    public Rectangle(int width, int height) {
    	super();
    	if(width>=0)
    		this.width = width;
    	else
    		this.width=0;
    	if(height>=0)
    		this.height = height;
    	else
    		this.height=0;
    }
    
    
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    public int getArea(){
    	return this.width*this.height;
    }
}
