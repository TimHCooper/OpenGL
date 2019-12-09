import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class OpenGL implements GLEventListener {
	
	double transX = 0.0;
	double transY = 0.0;
	
	int momY = 1;
	int momX = 1;

	public static void main(String[] args) 
	{
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		
		GLCanvas glcanvas = new GLCanvas(capabilities);
		OpenGL ogl = new OpenGL();
		glcanvas.addGLEventListener(ogl);
		glcanvas.setSize(400, 400);
		
		final JFrame frame = new JFrame ("OpenGL Test");
		
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		final FPSAnimator animator = new FPSAnimator(glcanvas, 60, true);
		animator.start();
	}

	@Override
	public void display(GLAutoDrawable drawable) 
	{
		GL2 gl = drawable.getGL().getGL2();
		gl.glColor3d(1.0, 0, 0);
		
		double width = 0.1;
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
		gl.glLoadIdentity();
		
		gl.glTranslated(transX, transY, 1.0);
		
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glColor3d(1.0, 0, 0);
		gl.glVertex3d(-width, width, 0);
		gl.glVertex3d(-width, -width, 0);
		gl.glVertex3d(width, -width, 0);
		gl.glVertex3d(width, width, 0);
		
		gl.glEnd();
		gl.glFlush();
		
		transX += (0.005 * momX);
		transY += (0.02 * momY);
		
		if(transX >= 1 - width || transX <= -1 + width)
			momX *= -1;
		
		if(transY >= 1 - width || transY <= -1 + width)
			momY *= -1;
	}

	@Override
	public void dispose(GLAutoDrawable drawable) 
	{
		
		
	}

	@Override
	public void init(GLAutoDrawable drawable) 
	{
		final GL2 gl = drawable.getGL().getGL2();
		
	      gl.glShadeModel( GL2.GL_SMOOTH );
	      gl.glClearColor( 0f, 0f, 0f, 0f );
	      gl.glClearDepth( 1.0f );
	      gl.glEnable( GL2.GL_DEPTH_TEST );
	      gl.glDepthFunc( GL2.GL_LEQUAL );
	      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
	{
		
	}

}
