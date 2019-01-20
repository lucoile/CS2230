package hw2;

public class SandBox {
   private final double length;    // doesn't change after SandBox is constructed   
   private final double width; // doesn't change after SandBox is constructed
   private final double height;// doesn't change after SandBox is constructed   

   // current height of the sand within the box
   public double sandHeight;  
   
    /*
     * Constructor 
     * Initially there is no sand in this SandBox
     */
    public SandBox(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
        this.sandHeight = 0;
    }
    
    // Constructor
	// Creates a SandBox with all dimensions 1
    // Initially there is no sand in this SandBox
    public SandBox(){
        this(1.0, 1.0, 1.0);
    }
		
	// getLength: returns the length of this SandBox
    public double getLength() { return length; }
	// getWidth: returns the width of this SandBox
    public double getWidth() { return width; }
	// getHeight: returns the height of this SandBox
    public double getHeight() { return height; }
	// getVolume: returns the total volume of this SandBox
    public double getVolume() { return length * width * height; }
	// getSandVolume: returns the volume of sand in this SandBox
    public double getSandVolume() { return length * width * sandHeight; }
    // toString: returns a String describing this SandBox
    //   for example, for the SandBox with length=10, width=12, height=2, sandHeight=1
    //   the String will be "SandBox(volume=240, sandVolume=120)"
	@Override
    public String toString() {
        return "SandBox(volume=" + getVolume() + ", sandVolume=" + getSandVolume() + ")"; 
    }

    // scoopSandFrom
    // Move sand from other into this SandBox.
    // If you would overflow this SandBox, *only* move the volume
    // of sand that would fill this SandBox to the top.
    public void scoopSandFrom(SandBox other){
        double freeVolume = this.getVolume() - this.getSandVolume();
        double extraSand = other.getSandVolume() - freeVolume;
        if (extraSand > 0) {
            other.sandHeight -= freeVolume / other.getWidth() / other.getLength();
            this.fillToTop();
        } else {
            this.sandHeight += other.getSandVolume() / this.width / this.length;
            other.sandHeight = 0;
        }
		// Don't remove these lines. They help you find errors more quickly
		// when debugging.
		this.checkState();	
		other.checkState();
    }

	private void checkState() {
		if (this.sandHeight > this.height) { throw new IllegalArgumentException("SandBox overflowed!"); }
		if (this.sandHeight < 0) { throw new IllegalArgumentException("SandBox contains anti-sand!"); }
	}

    // completely fills this SandBox with sand
    public void fillToTop() {
        sandHeight = height;
    }
}
