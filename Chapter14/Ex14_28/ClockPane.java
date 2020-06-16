// (c) Travis Dowd
// (d) 6-16-2020
//
// Chapter 14, exercise 28

package Ex14_28;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private double w = 250;
	private double h = 250;
	private boolean hourHandVisible;
	private boolean minuteHandVisible;
	private boolean secondHandVisible;
	public ClockPane() { setCurrentTime(); }
	public ClockPane( int hour, int minute, int second, double w, double h ) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock();
	}
	public void setHourHandVisible( boolean visible ) {
		this.hourHandVisible = visible;
		paintClock();
	}
	public void setMinuteHandVisible( boolean visible ) {
		this.minuteHandVisible = visible;
		paintClock();
	}
	public void setSecondHandVisible( boolean visible ) {
		this.secondHandVisible = visible;
		paintClock();
	}
	public void setHour( int hour ) { this.hour = hour; paintClock(); }
	public void setMinute( int minute ) { this.minute = minute; paintClock(); }
	public void setSecond( int second ) { this.second = second; paintClock(); }
	public void setW( double w ) { this.w = w; paintClock(); }
	public void setH( double h ) { this.h = h; paintClock(); }
	public int getHour() {
		return this.hour;
	}
	public int getMinute() {
		return this.minute;
	}
	public int getSecond() {
		return this.second;
	}
	public boolean getHourHandVisible() {
		return this.hourHandVisible;
	}
	public boolean getMinuteHandVisible() {
		return this.minuteHandVisible;
	}
	public boolean getSecondHandVisible() {
		return this.secondHandVisible;
	}
	public double getW() {
		return this.w;
	}
	public double getH() {
		return this.h;
	}
	public void paintClock() {
		// Initialize
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;
		// Draw Circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		// Second Hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		if ( this.getSecondHandVisible() == true ) { ;
			sLine.setStroke(Color.WHITE);
		} else {
			sLine.setStroke(Color.WHITE);
		}
		// Draw Minute Hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		if ( this.getMinuteHandVisible() == true ) {
			mLine.setStroke(Color.BLUE);
		} else {
			mLine.setStroke(Color.WHITE);
		}
		// Draw Hour Hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		if ( getHourHandVisible() == true ) {
			hLine.setStroke(Color.GREEN);
		} else {
			hLine.setStroke(Color.WHITE);
		}
		// Clean up
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
	}
}
