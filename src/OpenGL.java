import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

public class OpenGL implements GLEventListener {
	
	double angRot = 0.0;

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
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
		gl.glLoadIdentity();
		
		gl.glRotated(angRot, 0.0, 0.0, 1.0);
		
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex3d(-0.5, 0.5, 0);
		gl.glVertex3d(-0.5, -0.5, 0);
		gl.glVertex3d(0.5, -0.5, 0);
		gl.glVertex3d(0.5, 0.5, 0);
		
		gl.glEnd();
		gl.glFlush();
		
		angRot += 2.0;
	}

	@Override
	public void dispose(GLAutoDrawable drawable) 
	{
		
		
	}

	@Override
	public void init(GLAutoDrawable drawable) 
	{
		
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
	{
		
	}

}
