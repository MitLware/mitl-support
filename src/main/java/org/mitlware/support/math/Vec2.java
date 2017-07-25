package org.mitlware.support.math;

import org.mitlware.support.lang.Immutable;
import org.mitlware.support.lang.PubliclyCloneable;

//////////////////////////////////////////////////////////////////////

public final class Vec2
implements Comparable< Vec2 >, Immutable, PubliclyCloneable< Vec2 > {

    private double x_;
    private double y_;

	///////////////////////////////

	public Vec2( double x, double y ) {
		x_ = x;
		y_ = y;
	}

	public Vec2( Vec2 rhs ) {
		x_ = rhs.x_;
		y_ = rhs.y_;
	}

    // vector from p1 to p2
	public Vec2( Point2D p1, Point2D p2 ) {
		x_ = p2.getX() - p1.getX();
		y_ = p2.getY() - p1.getY();
	}

	///////////////////////////////

	public double getX() { return x_; }
	public double getY() { return y_; }

	public double modulus() { return java.lang.Math.sqrt( x_ * x_ + y_ * y_ ); }

	public double modulusSquared() { return x_ * x_ + y_ * y_; }

	///////////////////////////////

	public Vec2 add( Vec2 rhs ) {
		return new Vec2( x_ + rhs.x_, y_ + rhs.y_ );
	}

	public Vec2 subtract( Vec2 rhs ) {
		return new Vec2( x_ - rhs.x_, y_ - rhs.y_ );
	}

	public Vec2 multiply( double scalar ) {
		return new Vec2( x_ * scalar, y_ * scalar );
	}

	public double dotProduct( Vec2 rhs ) {
		return x_ * rhs.x_ + y_ * rhs.y_;
	}

	///////////////////////////////

	public boolean isUnitVector() {
		return Math.compareRelativeDifference( modulusSquared(), 1 );
	}

	public Vec2 toUnitVector() {

		if( isZeroVector() )
			throw new IllegalStateException();

		double sqrModulus = modulusSquared();
		double rx = x_, ry = y_;
		if( sqrModulus != 1 ) {
			double s = 1.0 / java.lang.Math.sqrt( sqrModulus );
			rx *= s;
			ry *= s;
		}

		Vec2 result = new Vec2( rx, ry );

		assert result.isUnitVector();

		return result;
	}

	///////////////////////////////

    public double angleBetween( Vec2 other ) {
		Vec2 h = new Vec2( this );
		h.toUnitVector();

		Vec2 d = new Vec2( other );
		d.toUnitVector();

		double cosine = h.dotProduct( d );
		double sine = h.x_ * d.y_ - h.y_ * d.x_;
		return java.lang.Math.atan2( sine, cosine );
	}

    public boolean isZeroVector() { return x_ == 0 && y_ == 0; }

    ///////////////////////////////

    public static double EuclidianDistance( Vec2 a, Vec2 b ) {
    	final double dx = a.x_ - b.x_;
    	final double dy = a.y_ - b.y_;
    	return java.lang.Math.sqrt( ( dx * dx ) + ( dy * dy ) );
    }

    public static double EuclidianDistanceSquared( Vec2 a, Vec2 b ) {
    	final double dx = a.x_ - b.x_;
    	final double dy = a.y_ - b.y_;
    	return ( dx * dx ) + ( dy * dy );
    }

    public int compareTo( Vec2 rhs ) {
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

    public boolean equals( Object o ) {
    	if( !( o instanceof Vec2 ) )
    		return false;

    	Vec2 rhs = (Vec2)o;
    	return x_ == rhs.x_ && y_ == rhs.y_;
    }

	public int hashCode() { return Double.valueOf( x_ ).hashCode() ^ Double.valueOf( y_ ).hashCode(); }

	public Vec2 clone() { return this; }

	public String toString() { return "(" + x_ + ',' + y_ + ')'; }
}

// End ///////////////////////////////////////////////////////////////
