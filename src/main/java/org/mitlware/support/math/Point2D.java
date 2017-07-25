package org.mitlware.support.math;

import org.mitlware.support.lang.Immutable;
import org.mitlware.support.lang.PubliclyCloneable;

//////////////////////////////////////////////////////////////////////

public class Point2D
implements Comparable< Point2D >, Immutable, PubliclyCloneable< Point2D > {

    private double x_;
    private double y_;

    ///////////////////////////////

	public Point2D( double x, double y ) {
		x_ = x;
		y_ = y;
	}

	public Point2D( java.awt.geom.Point2D p ) {
		x_ = p.getX();
		y_ = p.getY();
	}

    ///////////////////////////////

	public double getX() { return x_; }
	public double getY() { return y_; }

    ///////////////////////////////

	public java.awt.geom.Point2D.Double
	toPointAWT() {
		return new java.awt.geom.Point2D.Double( x_, y_ );
	}

    ///////////////////////////////

	public Point2D add( Vec2 v ) {
		return new Point2D( x_ + v.getX(), y_ + v.getY() );
	}

	public Point2D subtract( Vec2 v ) {
		return new Point2D( x_ - v.getX(), y_ - v.getY() );
	}

    ///////////////////////////////

    public int compareTo( Point2D rhs ) {
		if( x_ < rhs.x_ )
			return -1;
		else if( x_ > rhs.x_ )
			return 1;
		else if( y_ < rhs.y_ )
			return -1;
		else if( y_ > rhs.y_ )
			return 1;

		return 0;
	}

    @Override
    public boolean equals( Object o ) {
    	if( !( o instanceof Point2D ) )
    		return false;

    	Point2D rhs = (Point2D)o;
    	return x_ == rhs.x_ && y_ == rhs.y_;
    }

    @Override
	public int hashCode() {
		return hash( x_ ) ^ hash( y_ );
    }

	public Point2D clone() { return this; }

	private static int hash( double x )	{
		long bits = Double.doubleToLongBits( x );
		return (int)(bits ^ (bits >> 32));
	}

	public String toString() {
		return "(" + x_ + "," + y_ + ")";
	}

    ///////////////////////////////

	public static double squaredEuclidianDistance( Point2D a, Point2D b ) {
		double dx = a.x_ - b.x_;
		double dy = a.y_ - b.y_;
		return ( dx * dx ) + ( dy * dy );
	}

	public static double EuclidianDistance( Point2D a, Point2D b ) {
		double dx = a.x_ - b.x_;
		double dy = a.y_ - b.y_;
		return java.lang.Math.sqrt( ( dx * dx ) + ( dy * dy ) );
	}
}

// End ///////////////////////////////////////////////////////////////
