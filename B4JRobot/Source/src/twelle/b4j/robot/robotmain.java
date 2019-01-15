package twelle.b4j.robot;

import anywheresoftware.b4a.*;
import anywheresoftware.b4a.BA.*;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Wrapper fuer java.awt.Robot
 * <link>Documentation|https://twhub.de/doc/b4jrobot/index.html</link>
 */
@Version(0.2f)
@Author("Sebastian Wenzek")
@ShortName("B4JRobot")
@Events(values= {"MouseMove(x As Int, y As Int)", "MouseClicked(Button As String)", "MouseClicked2(Button As String, x As Int, y As Int)", "DragMouse(toX As Int, toY As Int)", "DragMouse2(x As Int, y As Int, toX As Int, toY As Int"})
public class robotmain {

	private boolean _init = false;
	private Robot _robot = null;
	private String _eventName = "";
	
	/**
	 * Initialisiert die Klasse.
	 * <code>Public rb As B4JRobot
	 * rb.Initialize("Event")</code>
	 */
	public void Initialize(BA b, String EventName) {
		if (BA.isB4J) {
			this._eventName = EventName.toLowerCase(BA.cul);
			try {
				this._robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				this.SendErrorReport(e.getMessage());
				//e.printStackTrace();
			}
			this._init = true;
		} else {
			this.SendErrorReport("[B4JRobot] Only available with B4J.");
		}
	}
	
	/**
	 * Bewegt die Maus zur angegebenen Position
	 * <code>Public br As B4JRobot
	 * br.Initialize("Event")
	 * br.MoveMouse(10, 20)</code>
	 */
	public void MoveMouse(final BA ba, int x, int y) {
		if (this._init) {
			this._robot.mouseMove(x, y);
			if (ba.subExists(this._eventName + "_mousemove")) {
				ba.raiseEvent(this, this._eventName + "_mousemove", x, y);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Bewegt die Maus zur angegebenen Position
	 */
	public void MoveMouse2(final BA ba, PointResult p) {
		if (this._init) {
			this._robot.mouseMove(p.X(), p.Y());
			if (ba.subExists(this._eventName + "_mousemove")) {
				ba.raiseEvent(this, this._eventName + "_mousemove", p.X(), p.Y());
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Links-Klick auf der selben Position der Maus
	 * <code>Public br As B4JRobot
	 * br.Initialize("Event")
	 * br.LeftClickMouse</code>
	 */
	public void LeftClickMouse(final BA ba) {
		if (this._init) {
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked", "left");
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Links-Klick an einer bestimmten Stelle
	 * <code>Public br As B4JRobot
	 * br.Initialize("Event")
	 * br.LeftClickMouse2(10, 20)</code>
	 */
	public void LeftClickMouse2(final BA ba, int x, int y) {
		if (this._init) {
			this._robot.mouseMove(x, y);
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked2")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked2", "left", x, y);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Links-Klick an einer bestimmten Stelle
	 */
	public void LeftClickMouse3(final BA ba, PointResult p) {
		if (this._init) {
			this._robot.mouseMove(p.X(), p.Y());
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked2")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked2", "left", p.X(), p.Y());
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Rechts-Klick an der aktuellen Mausposition
	 * <code>Public br As B4JRobot
	 * br.Initialize("Event")
	 * br.RightClickMouse</code>
	 */
	public void RightClickMouse(final BA ba) {
		if (this._init) {
			this._robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked", "right");
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Rechts-Klick an der angebenen Position
	 * <code>Public br As B4JRobot
	 * br.Initialize("Event")
	 * br.RightClickMouse2(10, 20)</code>
	 */
	public void RightClickMouse2(final BA ba, int x, int y) {
		if (this._init) {
			this._robot.mouseMove(x, y);
			this._robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked2")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked2", "right", x, y);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Rechts-Klick an der angebenen Position
	 */
	public void RightClickMouse3(final BA ba, PointResult p) {
		if (this._init) {
			this._robot.mouseMove(p.X(), p.Y());
			this._robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
			this._robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
			if (ba.subExists(this._eventName + "_mouseclicked2")) {
				ba.raiseEvent(this, this._eventName + "_mouseclicked2", "right", p.X(), p.Y());
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert ein "ziehen" der Maus von der aktuellen Position bis zur
	 * angegebenen Position
	 */
	public void DragMouse(final BA ba, int toX, int toY) {
		if (this._init) {
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseMove(toX, toY);
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_dragmouse")) {
				ba.raiseEvent(this, this._eventName + "_dragmouse", toX, toY);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert ein "ziehen" der Maus von der angebenen Position bis zur
	 * angebenen Position
	 */
	public void DragMouse2(final BA ba, int x, int y, int toX, int toY) {
		if (this._init) {
			this._robot.mouseMove(x, y);
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseMove(toX, toY);
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_dragmouse2")) {
				ba.raiseEvent(this, this._eventName + "_dragmouse2", x, y, toX, toY);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert ein "ziehen" der Maus von der angebenen Position bis zur
	 * angebenen Position
	 */
	public void DragMouse3(final BA ba, PointResult toPos) {
		if (this._init) {
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseMove(toPos.X(), toPos.Y());
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_dragmouse")) {
				ba.raiseEvent(this, this._eventName + "_dragmouse", toPos.X(), toPos.Y());
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert ein "ziehen" der Maus von der angebenen Position bis zur
	 * angebenen Position
	 */
	public void DragMouse4(final BA ba, PointResult from, PointResult toPos) {
		if (this._init) {
			this._robot.mouseMove(from.X(), from.Y());
			this._robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			this._robot.mouseMove(toPos.X(), toPos.Y());
			this._robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			if (ba.subExists(this._eventName + "_dragmouse2")) {
				ba.raiseEvent(this, this._eventName + "_dragmouse2", from.X(), from.Y(), toPos.X(), toPos.Y());
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert einen Tastendruck
	 */
	public void SendKey(final BA ba, int KeyCode) {
		if (this._init) {
			this._robot.keyPress(KeyCode);
			this._robot.keyRelease(KeyCode);
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert mehrere Tastendruecke
	 */
	public void SendKeys(final BA ba, int[] KeyCodes) {
		if (this._init) {
			for(int i = 0;i<KeyCodes.length;i++) {
				this._robot.keyPress(KeyCodes[i]);
				this._robot.keyRelease(KeyCodes[i]);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Simuliert mehrere Tastendruecke
	 */
	public void SendKeys2(final BA ba, String strText) {
		if (this._init) {
			int length = strText.length();
			for(int i = 0;i<length;i++) {
				char k = strText.charAt(i);
				int code = KeyEvent.getExtendedKeyCodeForChar(k);
				this._robot.keyPress(code);
				this._robot.keyRelease(code);
			}
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
		}
	}
	
	/**
	 * Gibt die aktuelle Mausposition (java.awt.Point) zurueck.
	 */
	public PointResult GetMouseLocation() {
		if (this._init) {
			Point _pos = MouseInfo.getPointerInfo().getLocation();
			PointResult p = new PointResult(_pos);
			return p;
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
			return null;
		}
	}
	
	/**
	 * Gibt auf der aktuellen Position der Maus die Pixelfarbe zurueck.
	 */
	public ColorResult GetPixelColor() {
		if (this._init) {
			Point pos = MouseInfo.getPointerInfo().getLocation();
			ColorResult c = new ColorResult(this._robot.getPixelColor(pos.x, pos.y));
			return c;
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
			return null;
		}
	}
	
	/**
	 * Gibt auf der angegebenen Position der Maus die Pixelfarbe zurueck.
	 */
	public ColorResult GetPixelColor2(int x, int y) {
		if (this._init) {
			ColorResult c = new ColorResult(this._robot.getPixelColor(x, y));
			return c;
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
			return null;
		}
	}
	
	/**
	 * Gibt auf der angegebenen Position der Maus die Pixelfarbe zurueck.
	 */
	public ColorResult GetPixelColor3(PointResult p) {
		if (this._init) {
			ColorResult c = new ColorResult(this._robot.getPixelColor(p.X(), p.Y()));
			return c;
		} else {
			this.SendErrorReport("[B4JRobot] Must be initalized!");
			return null;
		}
	}
	
	private void SendErrorReport(String message) {
		if (BA.debugMode) {
			BA.LogError(message);
		} else {
			Exception e = new Exception(message);
			e.printStackTrace();		
		}
	}
	
	public void MouseWheel(int wheelAmt) {
		this._robot.mouseWheel(wheelAmt);
	}
	
	/**
	 * Speichert eine Bildschirmaufnahme (Screenshot).
	 * Der zweite Parameter kann auch leergelassen werden ("")
	 * <code>
	 * ScreenCapture("C:\\Users\\xxx\\Desktop\\test.png", "png")
	 * ScreenCapture("C:\\Users\\xxx\\Desktop\\test.png", "")
	 * </code>
	 */
	public void ScreenCapture(String path, String format) {
		if (format == "") {
			format = "png";
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage img = this._robot.createScreenCapture(new Rectangle(screenSize.width, screenSize.height));
		java.io.File f = new java.io.File(path);
		try {
			ImageIO.write(img, format, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			this.SendErrorReport(e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public BufferedImage ScreenCapture2() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage img = this._robot.createScreenCapture(new Rectangle(screenSize.width, screenSize.height));
		return img;
	}
	
	public Image ScreenCapture3() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		BufferedImage img = this._robot.createScreenCapture(new Rectangle(screenSize.width, screenSize.height));
		Image img_result = (Image) img;
		return img_result;
	}
	
}
