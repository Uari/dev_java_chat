package com.week3;

import java.awt.Color;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
class FontPanel1 extends JPanel {// 페인트컴포먼트는 인터페이스 상속 필요 없다.

	Color color;

	Font font;

	JLabel mLabel;

	String str;

	public FontPanel1() {

		mLabel = new JLabel("HELL LOW WORD !!");

		add(mLabel);

	}

	@Override

	protected void paintComponent(Graphics g) {

		font = new Font("Monospaced", Font.PLAIN, 15);
		g.setFont(font);
		str = "HELL LOW WORD!";
		str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			color = new Color((int) (Math.random() * 255.0), (int) (Math.random() * 255.0),
					(int) (Math.random() * 255.0));
			g.setColor(color);
			g.drawString("" + str.charAt(i), 25 + (i * 11), 40);
		}
	}
}

public class CalcView extends JFrame {

	FontPanel1 panel1;
	Graphics g = new Graphics() {
		
		@Override
		public void translate(int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setXORMode(Color c1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setPaintMode() {
			// TODO Auto-generated method stub
			
		}
		
		
		
		@Override
		public void setClip(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setClip(Shape clip) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public FontMetrics getFontMetrics(Font f) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Font getFont() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Color getColor() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Rectangle getClipBounds() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Shape getClip() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(AttributedCharacterIterator iterator, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawString(String str, int x, int y) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawOval(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void drawLine(int x1, int y1, int x2, int y2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2,
				ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Graphics create() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void copyArea(int x, int y, int width, int height, int dx, int dy) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clipRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void clearRect(int x, int y, int width, int height) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void setFont(Font font) {
			
		}
		
		@Override
		public void setColor(Color c) {
			
		}
	};
	

	public CalcView() {

		Font font = new Font("굴림체", Font.BOLD, 16);
		g.setFont(font);
		g.setColor(Color.red);
		panel1.setFont(font);
		this.setSize(200, 100);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(panel1);

		this.setVisible(true);

	}

	public static void main(String[] args) {

		new CalcView();

		String a = "HELL";

		a.toCharArray();

		for (int i = 0; i < a.length(); i++) {

			System.out.print(a.charAt(i));

		}

	}

}
