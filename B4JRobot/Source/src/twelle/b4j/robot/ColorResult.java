package twelle.b4j.robot;

import anywheresoftware.b4a.BA.*;
import java.awt.Color;

@ShortName("ColorResult")
@Author("Sebastian Wenzek")
public class ColorResult {

	private Color _col = null;
	
	@Hide
	public ColorResult() {
		this._col = new Color(0, 0, 0);
	}
	
	@Hide
	public ColorResult(Color c) {
		this._col = c;
	}
	
	@Hide
	public ColorResult(int r, int g, int b) {
		this._col = new Color(r, g, b);
	}
	
	@Hide
	public ColorResult(float hue, float saturation, float brightness) {
		this._col = new Color(Color.HSBtoRGB(hue, saturation, brightness));
	}
	
	public void Initialize(int r, int g, int b) {
		this._col = new Color(r, g, b);
	}
	
	public void Initialize2(Color col) {
		this._col = col;
	}
	
	public void Initialize3(float hue, float saturation, float brightness) {
		this._col = new Color(Color.HSBtoRGB(hue, saturation, brightness));
	}
	
	public void Initialize4() {
		this._col = new Color(0, 0, 0);
	}
	
	public int R() {
		return this._col.getRed();
	}
	
	public int G() {
		return this._col.getGreen();
	}
	
	public int B() {
		return this._col.getBlue();
	}
	
	public int A() {
		return this._col.getAlpha();
	}
	
	public int GetTransparency() {
		return this._col.getTransparency();
	}
	
	public int GetRGB() {
		return this._col.getRGB();
	}
	
	public float[] GetHSB() {
		return Color.RGBtoHSB(this._col.getRed(), this._col.getGreen(), this._col.getBlue(), null);
	}
	
	public float[] GetHSB2(float[] hsbvals) {
		return Color.RGBtoHSB(this._col.getRed(), this._col.getGreen(), this._col.getBlue(), hsbvals);
	}
	
	public int GetRGBFromHSB(float hue, float saturation, float brightness) {
		return Color.HSBtoRGB(hue, saturation, brightness);
	}
}
