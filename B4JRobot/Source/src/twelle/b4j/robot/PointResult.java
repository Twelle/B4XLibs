package twelle.b4j.robot;

import anywheresoftware.b4a.BA.*;

import java.awt.Point;

@ShortName("PointResult")
@Author("Sebastian Wenzek")
public class PointResult {

	private Point _pos = null;
	
	@Hide
	public PointResult() {
		this._pos = new Point(0, 0);
	}
	
	@Hide
	public PointResult(Point p) {
		this._pos = p;
	}
	
	@Hide
	public PointResult(int x, int y) {
		this._pos = new Point(x, y);
	}
	
	public void Initialize() {
		this._pos = new Point(0, 0);
	}
	
	public void Initialize2(int x, int y) {
		this._pos = new Point(x, y);
	}
	
	public void Initialize3(Point p) {
		this._pos = p;
	}
	
	public int X() {
		return this._pos.x;
	}
	
	public int Y() {
		return this._pos.y;
	}
	
	public void SetLocation(int x, int y) {
		this._pos.setLocation(x, y);
	}
	
	public void SetX(int x) {
		this._pos.x = x;
	}
	
	public void SetY(int y) {
		this._pos.y = y;
	}
	
}
