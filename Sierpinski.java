import java.awt.*;

public class Sierpinski {
	public static void main(String[] args) {
		// Dýpt endurkvæmni. Lógóið er 4.
		int N = Integer.parseInt(args[0]);

		// Hnit þríhyrningsins
		double[] x = {0.18, 0.5, 0.82};
		double[] y = {0.7928, 0.1, 0.7928};

    // Stilli stærð striga
    StdDraw.setCanvasSize(2048,2048);

		// Endurkvæma fallið sem teiknar þríhyrningana.
		SieTri(N,x,y);

		// Yfirborðstegrið ( \u222E ) teiknað í miðjuna
		Font font = new Font("SansSerif",Font.PLAIN,132*4);
		StdDraw.setFont(font);
		StdDraw.setPenRadius(0.2);
		StdDraw.text(0.5,0.58,"\u222E",20);

		// Gerum hliðar lógósins þykkari.
		StdDraw.setPenRadius(0.004);
		StdDraw.polygon(x,y);

		// Vista lógóið
		StdDraw.save("Logo_2048.png");

	}

	// Teikna þríhyrning.
	public static void drawTri(double[] x, double[] y) {
		StdDraw.setPenColor(StdDraw.BLACK);
		//StdDraw.filledPolygon(x,y);
		StdDraw.polygon(x,y);
	}

	public static void SieTri(int n, double[] x, double[] y) {
		if (n == 0) {
			drawTri(x,y);
			return;
		}

		double[] x1 = new double[3]; // x-hnit left
		x1[0] = x[0];
		x1[1] = (x[1]+x[0])/2;
		x1[2] = x[1];

		double[] x2 = new double[3]; // x-hnit top
		x2[0] = (x[1]+x[0])/2;
		x2[1] = x[1];
		x2[2] = (x[2]+x[1])/2;

		double[] x3 = new double[3]; // x-hnit right
		x3[0] = x[1];
		x3[1] = (x[1]+x[2])/2;
		x3[2] = x[2];

		double[] y1_3 = new double[3]; // y-hnit left&right
		y1_3[0] = y[0];
		y1_3[1] = (y[1]+y[0])/2;
		y1_3[2] = y[2];

		double[] y2 = new double[3]; // y-hnit top
		y2[0] = y1_3[1];
		y2[1] = y[1];
		y2[2] = y1_3[1];

		SieTri(n-1, x1, y1_3); 	// low left
		SieTri(n-1, x2, y2); 	// top
		SieTri(n-1, x3, y1_3);	// low right

	}
}
